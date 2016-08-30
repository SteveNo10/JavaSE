package com.ifnoelse.webking;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class IdentityServlet extends HttpServlet {

	private static final long serialVersionUID = 1738733349245613850L;
	
	private static final char[] CHARS = {'2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
			'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};   //不包括 0 o 1 I 难辨认的字符
	
	public static Random random = new Random();
	
	public static String getRandomString() {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0; i<6; ++i) {
			stringBuffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return stringBuffer.toString();
	}
	
	public static Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	
	public static Color getReverseColor(Color color) {
		return new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpeg");
		String randomString = getRandomString();
		req.getSession(true).setAttribute("randomString", randomString);
		
		int width = 100;
		int height = 30;
		
		Color color = getRandomColor();
		Color reverseColor = getReverseColor(color);
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g = image.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverseColor);
		g.drawString(randomString, 18, 20);
		
		for(int i=0, n=random.nextInt(100); i<n; ++i) {
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		
		ServletOutputStream out = resp.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image);
		
		out.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
