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

public class Gender_Statistics{
	/**
	 * �Ա�ͳ�ƽ���
	 */
	ChartPanel frame1;
	public Gender_Statistics() {
		// TODO Auto-generated constructor stub

		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
                             "�Ա�ͳ��", // ͼ�����
                            "�Ա����", // Ŀ¼�����ʾ��ǩ
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
        dataset.addValue(ManNum(), "��", "��");
        dataset.addValue(WomenNum(), "Ů", "Ů");
        return dataset;
    }
    public static JPanel getPanel() {
    	JPanel jPanel=new JPanel();
		jPanel.setSize(680, 520);	
    	Gender_Statistics g=new Gender_Statistics();
    	jPanel.add(g.getChartPanel());	
    	return jPanel;
	}
    private static int ManNum() {
		int count=0;
		String sql="select * from student where find_in_set('��',sex)";
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
    private static int WomenNum() {
		int count=0;
		String sql="select * from student where find_in_set('Ů',sex)";
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
