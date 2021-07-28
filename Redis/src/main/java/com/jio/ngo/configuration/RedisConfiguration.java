package com.jio.ngo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration 
{
	@Autowired
	private Environment environment;
	
	@SuppressWarnings("deprecation")
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() 
	{
		LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
        /*connectionFactory.setHostName("localhost");
        connectionFactory.setPort(6379);*/
        connectionFactory.setHostName(environment.getProperty("spring.redis.host"));
        connectionFactory.setPort(6379);
        return connectionFactory;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	   RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
	   redisTemplate.setConnectionFactory(redisConnectionFactory());
	   redisTemplate.setEnableTransactionSupport(true);
	   return redisTemplate;
	}
	
     /*@Bean(name="redisTemplate")
     public RedisTemplate<String, Object> redisTemplate() 
     {
         RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
         redisTemplate.setConnectionFactory(redisConnectionFactory());
         redisTemplate.setEnableTransactionSupport(true);
         redisTemplate.setKeySerializer(new StringRedisSerializer());
         redisTemplate.setHashValueSerializer( new StringRedisSerializer() );
         redisTemplate.setHashKeySerializer( new StringRedisSerializer() );
         redisTemplate.setValueSerializer( new StringRedisSerializer() );
         redisTemplate.setStringSerializer( new StringRedisSerializer() );

         return redisTemplate;
     }*/
     
     @Bean
     public StringRedisTemplate stringRedisTemplate() 
     {
         StringRedisTemplate redisTemplate = new StringRedisTemplate();
         redisTemplate.setConnectionFactory(redisConnectionFactory());
         redisTemplate.setEnableTransactionSupport(true);
         redisTemplate.setKeySerializer(new StringRedisSerializer());
         redisTemplate.setHashValueSerializer( new StringRedisSerializer() );
         redisTemplate.setHashKeySerializer( new StringRedisSerializer() );
         redisTemplate.setValueSerializer( new StringRedisSerializer() );
         redisTemplate.setStringSerializer( new StringRedisSerializer() );
         return redisTemplate;
     }

}

