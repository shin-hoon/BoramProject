package com.boram.myPage.run;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �� �۵��ϴ��� Ȯ���Ұ�.
			int result = 0;// �ӽú���Ȯ��!!
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TEST.txt"))) {
				
				
			} catch (EOFException e) {
				// e.printStackTrace();
				System.out.println("�ҷ����� �Ϸ�.");
			} catch(FileNotFoundException e) {
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

}
