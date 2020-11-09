/*
 * 응용 어플리케이션에서 페이지 전환 방법을 한다.
 * 
 * */

package day1109.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainApp extends JFrame implements ActionListener{
	JPanel p_north;
	JPanel p_center;//여기에 페이지들이 위치함!
	JButton[] btn = new JButton[4];
	String[] title = {"Home", "게시판", "로그인", "회원가입"};
	
	/*4개의 준비된 페이지*/
	Home home;
	Board board;
	Login login;
	Member member;
	
	//패널들을 반복문으로 처리하려면, 개성있는 이름이 아니라,
	//순번으로 부르기 위한 배열이 편하다.
	JPanel[] pages = new JPanel[4];
	
	public MainApp() {
		p_north = new JPanel();
		p_center = new JPanel();
		
		//페이지 생성
		
		
		pages[0] = new Home();
		pages[1] = new Board();
		pages[2] = new Login();
		pages[3] = new Member();
		
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(title[i]);
			p_north.add(btn[i]);//북쪽 패널에 버튼 부착!
			
			btn[i].addActionListener(this);//버튼과 연결
		}
		
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		//페이지 스타일 설정
		pages[0].setPreferredSize(new Dimension(580, 480));
		pages[1].setPreferredSize(new Dimension(580, 480));
		pages[2].setPreferredSize(new Dimension(580, 480));
		pages[3].setPreferredSize(new Dimension(580, 480));
		
		
		//센터영역에 4개의 준비된 페이지를 붙어놓자!!
		p_center.add(pages[0]);
		p_center.add(pages[1]);
		p_center.add(pages[2]);
		p_center.add(pages[3]);
		
		setVisible(true);
		pack();//내용물의 크기만큼 수축!!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn[0]) {//home
			setPage(0);
			
		}else if(obj == btn[1]) {//board
			setPage(1);
			
		}else if(obj == btn[2]) {//login
			setPage(2);
			
		}else if(obj == btn[3]) {//member
			setPage(3);			
		}
	}
	
	//모든 페이지를 대상으로 반복문을 실행하되, 보여질 페이지만 true로
	//나머지는 false
	public void setPage(int index) {
		for (int i = 0; i < pages.length; i++) {
			
			if (index == i) {
				pages[i].setVisible(true);//보여질 페이지
			}else {
				pages[i].setVisible(false);//가려질 페이지
			}
		}
	}
	
	public static void main(String[] args) {
		new MainApp();
	}

}


















