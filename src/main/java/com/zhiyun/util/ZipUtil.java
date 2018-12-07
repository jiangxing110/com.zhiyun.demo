package com.zhiyun.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;

/**
 *  * 压缩包工具类  
 */
public class ZipUtil {
	private static final Logger logger = Logger.getLogger(ZipUtil.class);

	/**
	 * 解压zip文件 
	 * 
	 * @param zipFile
	 * @param unzipFilePath
	 *            解压后存放的路径
	 * @return 返回解压的路径文件夹
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static String unzip(File zipFile, String unzipFilePath)
			throws Exception {
		logger.trace("【update】解压文件:" + zipFile + "到路径:" + unzipFilePath);
		String unzipPath = "";
		// 判断文件是否存在
		if (!zipFile.exists() || zipFile.length() <= 0) {
			unzipPath = "false";
			return unzipPath;
		}
		if (zipFile.length() <= 0) {
			unzipPath = "false";
			return unzipPath;
		}
		// 创建解压缩文件保存的路径
		File unzipFileDir = new File(unzipFilePath);
		if (!unzipFileDir.exists() || !unzipFileDir.isDirectory()) {
			// 创建文件夹
			unzipFileDir.mkdirs();
		}
		// 开始解压
		logger.trace("开始解压....");
		// 创建解压对象
		ZipEntry zipEntry = null;
		// 文件保存路径路径
		String entryFilePath = null;
		// 文件夹路径
		String entryDirPath = null;
		// 创建问价对象
		File entryFile = null;
		// 创建文件夹对象
		File entryDir = null;
		int index = 0, count = 0, bufferSize = 1024;
		byte[] buffer = new byte[bufferSize];
		// 创建输出字符流
		BufferedInputStream bufferedInputStream = null;
		// 创建输入字符流
		BufferedOutputStream bufferedOutputStream = null;
		try {

			// 创建压缩文件对象
			ZipFile zip = new ZipFile(zipFile);
			Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zip
					.entries();
			// 第一步循环创建文件夹 第二步创建文件 第三部写入文件
			while (entries.hasMoreElements()) {
				zipEntry = entries.nextElement();
				logger.debug("当前的zip对象zipEntry:" + zipEntry.getName());
				logger.debug("当前解压路径unzipFilePath：" + unzipFilePath);
				boolean isDir = zipEntry.isDirectory();
				// 当前文件为文件夹
				if (isDir) {
					logger.debug("当前是个文件夹..." + zipEntry.getName());
					String dir = zipEntry.getName();
					entryFilePath = unzipFilePath + dir + "//";
					logger.debug("当前文件夹的完整路径是：" + entryFilePath);
					// 定义文件夹
					entryDir = new File(entryFilePath);
					// 如果文件夹路径不存在，则创建文件夹
					if (!entryDir.exists() || !entryDir.isDirectory()) {
						entryDir.mkdirs();
						logger.debug("创建文件夹：" + entryFilePath);
					}
				} else {
					// 当前是个文件
					logger.debug("判断当前是个文件：" + zipEntry.getName());
					entryFilePath = unzipFilePath + zipEntry.getName();
					logger.debug("当前文件的完整路径是entryFilePath:" + entryFilePath);
					File f = new File(entryFilePath);
					if (index != -1) {
						entryDirPath = f.getAbsolutePath().split(f.getName())[0];
					} else {
						entryDirPath = "";
					}
					logger.debug("entryDirPath:" + entryDirPath);
					unzipPath = entryDirPath;
					// 定义文件夹
					entryDir = new File(entryDirPath);
					// 如果文件夹路径不存在，则创建文件夹
					if (!entryDir.exists() || !entryDir.isDirectory()) {
						entryDir.mkdirs();
					}
					// 创建解压文件
					entryFile = new File(entryFilePath);
					// 写入文件
					bufferedOutputStream = new BufferedOutputStream(
							new FileOutputStream(entryFile));
					// 读取文件
					bufferedInputStream = new BufferedInputStream(
							zip.getInputStream(zipEntry));
					// 文件写入
					while ((count = bufferedInputStream.read(buffer, 0,
							bufferSize)) != -1) {
						bufferedOutputStream.write(buffer, 0, count);
					}
					bufferedOutputStream.flush();
					bufferedOutputStream.close();
				}
			}
			logger.debug("文件解压完毕...重新组装的路径是：" + unzipPath);
		} finally {
			try {
				if (null != bufferedInputStream) {
					bufferedInputStream.close();
				}
				if (null != bufferedOutputStream) {
					bufferedOutputStream.close();
				}
			} catch (Exception e2) {
			}
		}
		return unzipPath;
	}

	public static void main(String[] args) {
		File zipFile = new File("D:\\P01.000243.Z");
		System.out.println(zipFile.getName());

		try {
			// CompressorInputStream //zStreamFactory.getCompressorStream(null);
			// zStreamFactory.getCompressorStream(new FileInputStream(new
			// File("D://P01.000243.Z")));
			// boolean result = zipFile.renameTo(file);
			// System.out.println(result);
			// ZipUtil.unzip(file, "C://");
			System.out.println("解压完成！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
