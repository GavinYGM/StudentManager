package Child_Interface;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import Public.JDBC;

public class Politics_Statistics {
	ChartPanel frame1;
	public Politics_Statistics() {
		// TODO Auto-generated constructor stub
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
                             "������òͳ��", // ͼ�����
                            "������ò", // Ŀ¼�����ʾ��ǩ
                            "����", // ��ֵ�����ʾ��ǩ
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                            false,          // �Ƿ����ɹ���
                            false           // �Ƿ�����URL����
                            );
         
        //�����￪ʼ
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�
         domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����
         domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
         ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״
         rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
           
  		/* �رմ��� */
         frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame
	
	}
	public ChartPanel getChartPanel(){
	    return frame1;  
	}
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(PartyNum(), "��Ա", "��Ա");
        dataset.addValue(ProPartyNum(), "Ԥ����Ա", "Ԥ����Ա");
        dataset.addValue(ActivityNum(), "�뵳��������", "�뵳��������");
        dataset.addValue(LeagueNum(), "������Ա", "������Ա");
        dataset.addValue(MassesNum(), "Ⱥ��", "Ⱥ��");
        return dataset;
    }
    public static JPanel getPanel() {
    	JPanel jPanel=new JPanel();
		jPanel.setSize(680, 520);	
    	Politics_Statistics g=new Politics_Statistics();
    	jPanel.add(g.getChartPanel());	
    	return jPanel;
	}
    
    
    
    private static int PartyNum() {
		int count=0;
		String sql="select * from student where find_in_set('��Ա',politics)";
		ResultSet rs=JDBC.executeQuery(sql);
		try {
			while (rs.next()) {
				count+=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
    private static int ProPartyNum() {
		int count=0;
		String sql="select * from student where find_in_set('Ԥ����Ա',politics)";
		ResultSet rs=JDBC.executeQuery(sql);
		try {
			while (rs.next()) {
				count+=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
    private static int ActivityNum() {
		int count=0;
		String sql="select * from student where find_in_set('�뵳��������',politics)";
		ResultSet rs=JDBC.executeQuery(sql);
		try {
			while (rs.next()) {
				count+=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
    private static int LeagueNum() {
		int count=0;
		String sql="select * from student where find_in_set('������Ա',politics)";
		ResultSet rs=JDBC.executeQuery(sql);
		try {
			while (rs.next()) {
				count+=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
    private static int MassesNum() {
		int count=0;
		String sql="select * from student where find_in_set('������Ա',politics)";
		ResultSet rs=JDBC.executeQuery(sql);
		try {
			while (rs.next()) {
				count+=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
