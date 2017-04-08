package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		// ����socket������
		ServerSocket serverSocket = new ServerSocket(12345);
		System.out.println("������������....");
		DataInputStream input = null;
		DataOutputStream output = null;
		

		while (true) {
			try {
				// �����ͻ�������
				Socket socket = serverSocket.accept();

				// �õ�����������������
				input = new DataInputStream(socket.getInputStream());

				// �õ����������������
				output = new DataOutputStream(socket.getOutputStream());

				// ��������
				String cityName = input.readUTF();
				System.out.println("from clint:" + cityName);

				String result = "����";

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
