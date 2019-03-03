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
	 * 性别统计界面
	 */
	ChartPanel frame1;
	public Gender_Statistics() {
		// TODO Auto-generated constructor stub

		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
                             "性别统计", // 图表标题
                            "性别分类", // 目录轴的显示标签
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
        dataset.addValue(ManNum(), "男", "男");
        dataset.addValue(WomenNum(), "女", "女");
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
		String sql="select * from student where find_in_set('男',sex)";
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
		String sql="select * from student where find_in_set('女',sex)";
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
