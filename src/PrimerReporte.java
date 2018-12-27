import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



public class PrimerReporte extends JFrame{

	PrimerReporte()
	{
		setSize(300,100);
		setResizable(false);
		setTitle("Reporte");
		
		Util.centrarVentana(this);
		
		PanelReporte pnlSpinner = new PanelReporte();
		
		add(pnlSpinner);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		PrimerReporte ventana = new PrimerReporte();
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class PanelReporte extends JPanel implements ActionListener
{
	private JButton btn;
	PanelReporte()
	{
		//Boton Generar
		btn = new JButton("Generar");
		btn.addActionListener(this);
		add(btn);
		btn.setBounds(150, 210, 80, 30);
	}
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			JasperReport a = (JasperReport) JRLoader.loadObject(PrimerReporte.class.getResource("/reportes/Blank_A4_Landscape.jasper"));
			Map parametros = new HashMap<String,Object>();
			parametros.put("Titulo", "MI PRIMER REPORTE");	
			JasperPrint fillreport = JasperFillManager.fillReport(a,parametros, new JREmptyDataSource());
			JasperViewer jv = new JasperViewer(fillreport);
			jv.show();
		}
		catch(Exception r)
		{
			JOptionPane.showMessageDialog(this, r);
		}
	}
}

