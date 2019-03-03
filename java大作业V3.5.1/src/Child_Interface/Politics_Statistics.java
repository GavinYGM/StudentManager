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
                             "政治面貌统计", // 图表标题
                            "政治面貌", // 目录轴的显示标签
                            "人数", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
         
        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
           
  		/* 关闭窗口 */
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
	
	}
	public ChartPanel getChartPanel(){
	    return frame1;  
	}
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(PartyNum(), "党员", "党员");
        dataset.addValue(ProPartyNum(), "预备党员", "预备党员");
        dataset.addValue(ActivityNum(), "入党积极分子", "入党积极分子");
        dataset.addValue(LeagueNum(), "共青团员", "共青团员");
        dataset.addValue(MassesNum(), "群众", "群众");
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
		String sql="select * from student where find_in_set('党员',politics)";
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
		String sql="select * from student where find_in_set('预备党员',politics)";
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
		String sql="select * from student where find_in_set('入党积极分子',politics)";
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
		String sql="select * from student where find_in_set('共青团员',politics)";
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
		String sql="select * from student where find_in_set('共青团员',politics)";
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
