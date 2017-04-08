package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		// 启动socket服务器
		ServerSocket serverSocket = new ServerSocket(12345);
		System.out.println("服务器已启动....");
		DataInputStream input = null;
		DataOutputStream output = null;
		

		while (true) {
			try {
				// 监听客户端连接
				Socket socket = serverSocket.accept();

				// 得到输入流，接收数据
				input = new DataInputStream(socket.getInputStream());

				// 得到输出流，发生数据
				output = new DataOutputStream(socket.getOutputStream());

				// 城市名称
				String cityName = input.readUTF();
				System.out.println("from clint:" + cityName);

				String result = "晴天";

				output.writeUTF(result);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.close();
				}
			}
		}
	}
}
