package test;

import java.util.Random;

import test.SendEmail;

public class SendEmailTest {
	public static void main(String[] args) {
		SendEmail sendEmail=new SendEmail();
		//����Ҫ���͵�����
		sendEmail.setReceiveMailAccount("1798104163@qq.com");
		//����6λ����֤��
		Random random=new Random();
		String str="";
		for(int i=0;i<6;i++) {
			int n=random.nextInt(10);
			str+=n;
		}
		sendEmail.setInfo(str);
		try {
			sendEmail.Send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
}