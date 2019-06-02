package com.boram.shopping.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.boram.manager.vo.Product;
import com.boram.manager.vo.ProductDao;
import com.boram.shopping.view.MainView;
public class ShoppingParsing {
	private ProductDao productDao = new ProductDao();
	private int cnt = 0;
	private int pNo = 1;
	
	private int[] category = {
		1,                  // Best Sellers
		11,12,13,14,        // ��Ʈ, ����, ������, �����
		21,22,23,24,25,     // ����, ����/����, ������/�ĵ�Ƽ, ��Ʈ, ������
		31,32,33,           // �⺻����, ���ϼ���, ���ȼ���
		41,42,43,44,45,46,  // ������, ������, û����, �ݹ���, Ʈ���̴�, UP��������
		51,52,53            // ����Ŀ��, ����/��Ŀ, ������/����
	};
	
	private String[] categoryEng = {
		"Best Sellers",														          
		"coat", "jacket", "blazer", "cardigan",                                       
		"LongSleeve", "ShortSleeves", "hoodT", "neat", "overFit",                     
		"nomalShirt", "patternShirt", "shortShirt",                                   
		"Slacks", "cottonPants",  "blueJeans",  "shorts", "training", "upDenimPants", 
		"Sneakers", "Walker", "slipper"
	};
	
	private String[] connect = {
			"https://m.mutnam.com/",                               // Best Sellers
			"https://m.mutnam.com/product/list.html?cate_no=50",   // ��Ʈ
			"https://m.mutnam.com/product/list.html?cate_no=82",   // ����
			"https://m.mutnam.com/product/list.html?cate_no=165",  // ������
			"https://m.mutnam.com/product/list.html?cate_no=397",  // �����
			"https://m.mutnam.com/product/list.html?cate_no=140",  // ����
			"https://m.mutnam.com/product/list.html?cate_no=123",  // ����/����
			"https://m.mutnam.com/product/list.html?cate_no=398",  // ������/�ĵ�Ƽ
			"https://m.mutnam.com/product/list.html?cate_no=76",   // ��Ʈ
			"https://m.mutnam.com/product/list.html?cate_no=318",  // ������
			"https://m.mutnam.com/product/list.html?cate_no=105",  // �⺻����
			"https://m.mutnam.com/product/list.html?cate_no=92",   // ���ϼ���
			"https://m.mutnam.com/product/list.html?cate_no=301",  // ���ȼ���
			"https://m.mutnam.com/product/list.html?cate_no=111",  // ������
			"https://m.mutnam.com/product/list.html?cate_no=169",  // ������
			"https://m.mutnam.com/product/list.html?cate_no=75",   // û����
			"https://m.mutnam.com/product/list.html?cate_no=116",  // �ݹ���
			"https://m.mutnam.com/product/list.html?cate_no=282",  // Ʈ���̴�
			"https://m.mutnam.com/product/list.html?cate_no=348",  // UP��������
			"https://m.mutnam.com/product/list.html?cate_no=161",  // ����Ŀ��
			"https://m.mutnam.com/product/list.html?cate_no=246",  // ����/��Ŀ
			"https://m.mutnam.com/product/list.html?cate_no=211",  // ������/����
	};
	
	/**
	 *  ���ּҿ� �ش��ϴ�
	 *  HTML�±׸� ����ͼ� ���ϴ� �̹��� �� �����͸� �������� ���
	 *  �ʱ�ȭ �ϰ���� ���� ���� �ߴٰ� �ٽ� �Ľ�
	 *  ��, �Ľ� �۾��� �� ������ �ҿ�ð� ����
	 *  �Ľ��� �����ų� ���� ������ ������
	 *  ������Ʈ �ѹ� Ŭ���� �� ���ΰ�ħ �ؾ� ����Ϸ�
	 *  ��� �� �ּ� �ʼ�!!
	 */
	public static void main(String[] args) {
		ShoppingParsing sp = new ShoppingParsing();
		// �Ľ� start
		//sp.fileSave();
		
		// ���� �����
	/*	
		sp.deleteFile(MainView.PATH + "file");
		System.out.println("file ������ ���� �Ǿ����ϴ�.");
		sp.deleteFile(MainView.PATH + "image\\category");
		System.out.println("category ������ ���� �Ǿ����ϴ�.");
	*/	
	}
	
	
	public void fileSave() {
		productDao.fileSave(parsingStart());
		System.out.println("����");
	}
	
	
	public void deleteFile(String path) {
		File deleteFolder = new File(path);

		if(deleteFolder.exists()){
			File[] deleteFolderList = deleteFolder.listFiles();
			
			for (int i = 0; i < deleteFolderList.length; i++) {
				if(deleteFolderList[i].isFile()) {
					deleteFolderList[i].delete();
				}else {
					deleteFile(deleteFolderList[i].getPath());
				}
				deleteFolderList[i].delete(); 
			}
			deleteFolder.delete();
		}
	}
	
	
	
	public List<Product> parsingStart() {
		List<Product> dataList = new ArrayList<>();
		
		try {
			for (int m = 0; m < category.length; m++) {
				Document doc = Jsoup.connect(connect[m]).get();
				Elements img = doc.select("div.thumbnail a img");
				Elements title = doc.select("div.description strong.name a");
				Elements price = doc.select("div.description div.spec p.price");
				
				for(int i = 0; i < img.size(); i++) {
					Element imgTmp = img.get(i);
					Element titleTmp = title.get(i);
					Element priceTmp = price.get(cnt);
					Document contentDoc = Jsoup.connect("https://m.mutnam.com/"+titleTmp.attr("href")).get();
					Elements contentExplain = contentDoc.select("ul.txt_area li ul li");
					
					
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < contentExplain.size(); j++) {
						Element contentExplainTmp = contentExplain.get(j);
						sb.append(contentExplainTmp.text());
					}
					if(sb.toString().equals("")) {
						Elements contentExplain2 = contentDoc.select("div#prdDetailContent ul li");
						for(int k = 0; k < contentExplain2.size(); k++) {
							Element contentExplainTmp2 = contentExplain2.get(k);
							sb.append(contentExplainTmp2.text());
						}
						if(sb.toString().equals("")) {
							sb.append("��ǰ ������ ��ϵ��� �ʾҽ��ϴ�.");
						}
					}
					
					Product vo = new Product();
					
					vo.setpNo(pNo++);        
					vo.setCategory(category[m]); 
					vo.setProductName(titleTmp.text());
					String replace = priceTmp.text().replaceAll(",", "");
					vo.setPrice(Integer.parseInt(replace.substring(0, replace.lastIndexOf("��"))));
					vo.setSize("free");
					vo.setExplain(sb.toString());

					File fileDir = new File(MainView.PATH + "image\\category\\"+categoryEng[m]+"\\");
					if(!fileDir.exists()) fileDir.mkdirs();

					String fileName = imgTmp.attr("src").substring(imgTmp.attr("src").lastIndexOf("/")+1, imgTmp.attr("src").length());
					File imgFile = new File(fileDir,fileName);
					URL url = null;
					BufferedImage bi = null;
					
					try {
						url = new URL("https:"+imgTmp.attr("src"));
						bi = ImageIO.read(url);
						ImageIO.write(bi, "png", imgFile);
					} catch (Exception ex) {
						System.out.println("���� ���� ���� : " + ex.getMessage());
					} // end try-catch
					vo.setImgFilePath("image\\category\\"+categoryEng[m]+"\\"+imgFile.getName());
					vo.setStock(10);
					vo.setCount(10);
					dataList.add(vo);
					cnt += 2;
					System.out.println(vo.toString());
					if(i == 21) break;
				} // end for
				cnt=0;
			} // end for
		} catch(Exception e) {
			System.out.println("�Ľ̿��� : " + e.getMessage());
		} // end try-catch
		return dataList;
	}
} // end class