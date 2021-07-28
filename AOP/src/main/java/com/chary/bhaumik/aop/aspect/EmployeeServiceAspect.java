package com.chary.bhaumik.aop.aspect;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect 
{
	
	/**
	System.out.println("Before GetSignature() method:" + joinPoint.getSignature());
	System.out.println("Before GetDeclaringTypeName() method:" + joinPoint.getSignature().getDeclaringTypeName());
	System.out.println("Before GetName() method:" + joinPoint.getSignature().getName());
	System.out.println("Before GetTarget() method:" + joinPoint.getTarget());
	*/
		 
	/**
	 *   Scenario One
	 *   By Using Method Name
	 *   Drawback is applies to all the Methods
	 *   that has the Same Name
	 */
	
	//@Before("execution(public * createEmployee(..))")
	public void beforeAdviceMethod(JoinPoint joinPoint)
	{
		List<String> paramList=joinPoint.getArgs()!=null?
		Stream.of(joinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList(); 
		System.out.println("Befor Execution "+
		joinPoint.getSignature().getName()+ "() in "+
		joinPoint.getSignature().getDeclaringTypeName() +
		" With Parameters :"+paramList);
	}
	
	//@After("execution(public * createEmployee(..))")
	public void afterAdviceMethod(JoinPoint joinPoint)
	{
		List<String> paramList=joinPoint.getArgs()!=null?
		Stream.of(joinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList(); 
		System.out.println("After Execution "+
		joinPoint.getSignature().getName()+ "() in "+
		joinPoint.getSignature().getDeclaringTypeName() +
		" With Parameters :"+paramList);
	}
	
	
	/**
	 *   Scenario Two
	 *   By Using Complete Path
	 *   We can restrict the advice to a Single Method
	 */
	
	//@Before("execution(public * com.chary.bhaumik.aop.dao.EmployeeDaoImpl.createEmployee(..))")
	public void beforeAdviceUnique(JoinPoint joinPoint)
	{
		List<String> paramList=joinPoint.getArgs()!=null?
		Stream.of(joinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList(); 
		System.out.println("Before Execution "+
		joinPoint.getSignature().getName()+ "() in "+
		joinPoint.getSignature().getDeclaringTypeName() +
		" With Parameters :"+paramList);
	}
	
	//@After("execution(public * com.chary.bhaumik.aop.dao.EmployeeDaoImpl.createEmployee(..))")
	public void afterAdviceUnique(JoinPoint joinPoint)
	{
		List<String> paramList=joinPoint.getArgs()!=null?
		Stream.of(joinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList(); 
		System.out.println("After Execution "+
		joinPoint.getSignature().getName()+ "() in "+
		joinPoint.getSignature().getDeclaringTypeName() +
		" With Parameters :"+paramList);
	}
	
	
	/**
	 *   Scenario Three
	 *   Single Advice has to be applied 
	 *   for Multiple Point cuts
	 *   We use Point Cut 
	 */
	//@Before("employeeControllerPointcut() || employeeServicePointcut() || employeeDaoPointcut() ")
	public void beforeAdvicePointcut(JoinPoint joinPoint)
	{
		List<String> paramList=joinPoint.getArgs()!=null?
		Stream.of(joinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList(); 
		System.out.println("Started Executing "+
		joinPoint.getSignature().getName()+ "() in "+
		joinPoint.getSignature().getDeclaringTypeName() +
		" With Parameters {} "+paramList);
	}
	
	@Pointcut("within(com.chary.bhaumik.aop.controller.EmployeeController)")
	public void employeeControllerPointcut()
	{
	}
	 
	@Pointcut("within(com.chary.bhaumik.aop.service.EmployeeServiceImpl)")
	public void employeeServicePointcut()
	{
	}
	 
	@Pointcut("within(com.chary.bhaumik.aop.dao.EmployeeDaoImpl)")
	public void employeeDaoPointcut() 
	{
	}
	
	/**
	 *   Scenario Four
	 *   Advice Method has to be executed
	 *   Only if the Target Method is Successfully Executed
	 *   We use After Returning 
	 */
	//@AfterReturning("employeeControllerPointcut() || employeeServicePointcut() || employeeDaoPointcut()")
	public void afterReturnningAdvice(JoinPoint joinPoint)
	{
		List<String> paramList=joinPoint.getArgs()!=null?
		Stream.of(joinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList();
		System.out.println("Ended Executing "+
		joinPoint.getSignature().getName()+ "() in "+
		joinPoint.getSignature().getDeclaringTypeName()+
		" With Parameters :"+paramList);
	}
	
	/**
	 *   Scenario Five
	 *   Advice Method has to be executed
	 *   Before and After the execution of the Method
	 *   We use @Around 
	 */
	//@Around("employeeControllerPointcut() || employeeServicePointcut() ")
	public Object aroundReturningResultAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		Object resultObject = proceedingJoinPoint.proceed();
		System.out.println("Ended Executing "+
		proceedingJoinPoint.getSignature().getName()+ "() in "+
		proceedingJoinPoint.getSignature().getDeclaringTypeName() +
		" With Result :"+resultObject);
		return resultObject;
	}
	
	//@Around("employeeDaoPointcut()")
	public void aroundExecutionTimeAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		List<String> paramList=proceedingJoinPoint.getArgs()!=null?
		Stream.of(proceedingJoinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList(); 
		long startTime=System.currentTimeMillis();
		System.out.println("Query Started Executing : "+
		proceedingJoinPoint.getSignature().getName()+ 
		" With Parameters : "+paramList+ 
		" In "+proceedingJoinPoint.getSignature().getDeclaringTypeName());
		proceedingJoinPoint.proceed();
		System.out.println("Query Ended Executing : "+
		proceedingJoinPoint.getSignature().getName()+
		" With Parameters : "+paramList+ 
		" In "+proceedingJoinPoint.getSignature().getDeclaringTypeName() +
		"Executed In "+
		(System.currentTimeMillis()-startTime)+" Seconds");
	}

	/**
	 *   Scenario Six
	 *   Advice Method has to be executed
	 *   Only after Target Method gets an Error
	 *   We use @AfterThrowing 
	 */
	@AfterThrowing(pointcut = "employeeControllerPointcut()", throwing="ex")
	public void afterThrowingErrorAdvice(JoinPoint joinPoint,Throwable ex)
	{
		List<String> paramList=joinPoint.getArgs()!=null?
		Stream.of(joinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList(); 
		System.out.println("Exception Occured In "+
		ex.getStackTrace()[0].getMethodName()+ "() with Parameters "+
		paramList+" Of "+
		ex.getStackTrace()[0].getFileName() +
		" At Line Number "+ex.getStackTrace()[0].getLineNumber() +
		" With Error Message : "+ex.getMessage());
	}
	
	/**@Before("execution(public * com.chary.bhaumik.aop.dao.EmployeeDaoImpl.createEmployee(..)) and args(name,empId)")
	public void beforeAdvice(JoinPoint joinPoint, String name, String empId)
	{
		List<String> paramList=joinPoint.getArgs()!=null?
		Stream.of(joinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList(); 
		System.out.println("Executed "+
		joinPoint.getSignature().getName()+ "() in "+
		joinPoint.getSignature().getDeclaringTypeName() +
		" With Parameters :"+paramList);
		System.out.println("Before Creating Employee with name - " + name + " and id - " + empId);
	}**/
	
	/**@Before("execution(public * com.chary.bhaumik.aop.dao.EmployeeDaoImpl.createEmployee(..))")
	public void beforeAdvice(JoinPoint joinPoint)
	{
		List<String> paramList=joinPoint.getArgs()!=null?
		Stream.of(joinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList(); 
		System.out.println("Executed "+
		joinPoint.getSignature().getName()+ "() in "+
		joinPoint.getSignature().getDeclaringTypeName() +
		" With Parameters :"+paramList);
	}**/
	
	/**@After("execution(public * com.chary.bhaumik.aop.dao.EmployeeDaoImpl.createEmployee(..)) and args(name,empId)")
	public void afterAdvice(JoinPoint joinPoint, String name, String empId)
	{
		System.out.println("After method:" + joinPoint.getSignature());
		System.out.println("After Creating Employee with name - " + name + " and id - " + empId);
	}**/
	
	/**@After("execution(public * com.chary.bhaumik.aop.dao.EmployeeDaoImpl.createEmployee(..))")
	public void afterAdvice(JoinPoint joinPoint)
	{
		System.out.println("After method:" + joinPoint.getSignature());
	}**/
	
	/**@Around("within(com.chary.bhaumik.aop.service.EmployeeServiceImpl)")
	public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		List<String> paramList=proceedingJoinPoint.getArgs()!=null?
		Stream.of(proceedingJoinPoint.getArgs())
		.map(object -> String.valueOf(object))
		.collect(Collectors.toList())
		:Collections.emptyList(); 
		System.out.println("Started Executing "+
		proceedingJoinPoint.getSignature().getName()+ "() in "+
		proceedingJoinPoint.getSignature().getDeclaringTypeName() +
		" With Parameters :"+paramList);
		proceedingJoinPoint.proceed();
		System.out.println("Ended Executing "+
		proceedingJoinPoint.getSignature().getName()+ "() in "+
		proceedingJoinPoint.getSignature().getDeclaringTypeName() +
		" With Parameters :"+paramList);
	}**/
	
}
