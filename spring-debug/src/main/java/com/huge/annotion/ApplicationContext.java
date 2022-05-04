package com.huge.annotion;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sean
 */
public class ApplicationContext {

	/**
	 * IOC容器
	 */
	private Map<String, Object> beanMap = new ConcurrentHashMap<String, Object>();


	/**
	 * 通过beanName名称获取bean的实例
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName) {
		return beanMap.get(beanName);
	}


	/**
	 * 构造方法
	 * @param packagePath 包路径
	 */
	public ApplicationContext(String packagePath) {
		// 扫描指定的包路径
		scanPackagePath(packagePath);
	}

	/**
	 * 扫描指定的包路径
	 * @param packagePath 包路径
	 */
	private void scanPackagePath(String packagePath) {
		//1、获取这个目录下面所有的class文件
		File[] classFile = getClassFile(packagePath);
		//2、处理所有的class文件,对添加了@MyComponent注解类创建实例并且添加到IOC容器
		processClassFile(packagePath,classFile);
	}

	/**
	 * 处理所有的class文件
	 * @param packagePath 包路径
	 * @param classFile 文件对象
	 */
	private void processClassFile(String packagePath, File[] classFile) {
		for (File file : classFile) {
			//1、去除后缀，获取class文件名
			String className = file.getName().substring(0, file.getName().lastIndexOf("."));
			//2、拼接全限定类名
			String fullClassName = packagePath + "." + className;
			//3、将类名称首字母转小写，得到beanName
			String beanName = String.valueOf(className.charAt(0)).toLowerCase() + className.substring(1);
			//4、创建实例并放入到ICO容器中
			createBean(beanName,fullClassName);
		}

	}

	/**
	 * 创建实例并放入到IOC容器中
	 * @param beanName bean的
	 * @param fullClassName
	 */
	private void createBean(String beanName, String fullClassName) {
		try {
			//1、通过反射创建出class对象
			Class<?> cls = Class.forName(fullClassName);
			//2、判断这个类上是否加了@MyCompent注解
			if (cls.isAnnotationPresent(MyComponent.class)) {

				// 3、通过反射创建出实例
				Object instance = cls.newInstance();

				// 4、将实例放入到IOC容器中
				beanMap.put(beanName,instance);
			}else {
				System.out.println(fullClassName+ " 不需要创建实例");
			}
		}catch (Exception e) {
			System.out.println(fullClassName + " 通过实例出现异常");
		}

	}

	/**
	 * 获取这个目录下面所有的class文件
	 * @param packagePath
	 * @return
	 */
	private File[] getClassFile(String packagePath) {
		// 1、通过packagePath 获取对应的file对象
		File file = getFile(packagePath);
		//2、过滤出所有的class文件
		return filterClassFile(packagePath,file);
	}

	/**
	 * 过滤出所有的class文件
	 * @param packagePath 包路径
	 * @param file 文件对象
	 * @return
	 */
	private File[] filterClassFile(final String packagePath, File file) {
		//1、过滤出文件下面的所有class文件
		return file.listFiles(f -> {
			String fileName = f.getName();
			//2、如果是目录，那么需要在此扫描这个目录下所有文件（递归调用）
			if (f.isDirectory()) {
				scanPackagePath(packagePath+"."+fileName);
			}else {
				//3、如果文件后缀是.class，就返回true
				if (fileName.endsWith(".class")) {
					return true;
				}
			}
			return false;
		});
	}

	/**
	 * 获取对应的file文件
	 * @param packagePath 包路径
	 * @return
	 */
	private File getFile(String packagePath) {
		//1、将包路径中的"."替换为"/"
		String packageDir = packagePath.replaceAll("\\.", "/");
		//2、获取这个目录在类路径中的位置
		URL url = getClass().getClassLoader().getResource(packageDir);
		//3、通过目录获取到文件对象
		return new File(url.getFile());
	}


}

