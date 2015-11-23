/**
 * 2015年11月15日
 *author:
 *description:
 */
package presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.img.Img;
import vo.OrderListVO;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;

/**
 * @author 谭期友
 *
 */
public class SearchPanel extends JPanel{
	
	private static final long serialVersionUID = -715445060249204486L;
	private SearchPkgInformationBLService bl;
	private MainFrame mf;
	
	private MyButton close;
	private MyButton min;
	private MyButton search;
	private MyButton _return;
	
	private JTextField orderField;
	
	private boolean Invalid;//输入是否非法
	private String result;

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BG, 0, 0, MainFrame.w, MainFrame.h/2, null);
        
        if(Invalid){
        	g.drawImage(Img.BLACK_BG, 0, MainFrame.h-50, MainFrame.w, 50, null);
        	
            g.setColor(Color.RED);
            g.setFont(new Font("楷体", Font.BOLD, 26));
            //g.drawString(result, -result.length()*13, 13);
            g.drawString(result, -result.length()*13+MainFrame.w/2, 13+MainFrame.h-30);
        }
	}
	
	public SearchPanel(MainFrame mf, SearchPkgInformationBLService bl){
		this.mf=mf;
		this.bl=bl;
		Invalid=false;
		result="";
		this.setLayout(null);

		//初始化组件
		initComponent();
	}
	private void initComponent() {
		close = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        close.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        min = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        min.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				mf.setExtendedState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        search = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        search.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				searchInf();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        _return = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        _return.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();//清空文本域和错误提示
				mf.setStated(mf.getState());
				mf.setState(0);
				mf.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        JLabel orderLabel = new JLabel("订单号：");
        orderLabel.setSize(80, 20);
        orderLabel.setFont(new Font("楷体", Font.BOLD, 18));
        orderField = new JTextField();
        orderField.setSize(150, 20);

        
        orderLabel.setLocation(MainFrame.w/2-120,MainFrame.h*3/4-60);
        orderField.setLocation(MainFrame.w/2-50,MainFrame.h*3/4-60);
    	close.setLocation(MainFrame.w-30,0);
    	min.setLocation(MainFrame.w-80,0);
    	search.setLocation(MainFrame.w-100,MainFrame.h*3/4-60);
    	_return.setLocation(MainFrame.w-100,MainFrame.h*3/4-30);
    	
    	
    	add(orderLabel);
    	add(orderField);
        add(close);
        add(min);
        add(search);
        add(_return);
	}

	private void clear(){
		orderField.setText("");
		Invalid=false;
		repaint();
	}
	private void searchInf(){
		/*String order = orderField.getText();
		result = CheckFormat.checkOrderNum(order);
		if(result.compareTo("格式正确")!=0){
			Invalid=true;
			repaint();
			new Thread(new Runnable(){
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
					Invalid=false;
					repaint();
				}
			}).start();
			return;
		}
		
		
		//OrderListVO orderListVO = bl.searchPkgInformation(order);
		OrderListVO orderListVO = null;
		if(orderListVO==null){//查无此订单
			Invalid=true;
			result = "查无此订单！";
			repaint();
			new Thread(new Runnable(){
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					Invalid=false;
					repaint();
				}
			}).start();
		}else{//有此订单
			;
		}*/
		new PkgInformationFrame();
	}
}
