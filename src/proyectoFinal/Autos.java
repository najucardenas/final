package proyectoFinal;
import javax.swing.JFileChooser;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
//import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
//import java.lang.System.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;

public class Autos extends JFrame {
	private static final CopyOption REPLACE_EXISTING = null;
	private FileNameExtensionFilter filter=new FileNameExtensionFilter("archivos de imagen","jpg","png");
	private BufferedImage ima;
	JComboBox cbmarca = new JComboBox();
	JComboBox cbversion = new JComboBox();
	JLabel URLtexto = new JLabel("");
	JTextField tfid = new JTextField();
	JPanel panel_2;
	JPanel panel_3; 
	JLabel lblImagenOriginal ;
	int indice;
	String version;
	int ba=0;
	JLabel lblImagenOriginal1 ;
	JFileChooser file=new JFileChooser();
	Automoviles autos1[]=new Automoviles[20];
	public int posi=8;
//	imagenF image=new imagenF();
	
	private JPanel contentPane;
	private final JLabel lbMarca = new JLabel("Marca");
	private final JLabel lbModelo = new JLabel("Modelo");
	private final JLabel lbMotor = new JLabel("Motor");
	private final JLabel lbTransmision = new JLabel("Transmisión");
	private final JLabel llbPrecio = new JLabel("Precio");
	private final JTextField tfmarca = new JTextField();
	private final JTextField tfmodelo = new JTextField();
	private final JTextField tfmotor = new JTextField();
	private final JTextField tftransmision = new JTextField();
	private final JTextField tfprecio = new JTextField();
	private JTextField tfversion;
	private final JLabel lblId = new JLabel("ID");
	private final JComboBox cbid = new JComboBox();
	private final JLabel lblId_1 = new JLabel("ID");
	private final JLabel lblNewLabel_3 = new JLabel("Maximo registros 20");
	private final JLabel lblid = new JLabel("20");
	private JTextField tfvmotor;
	private JTextField tfvprecio;
	private JTextField tfvtransmision;
	private JTextField tfidbuscar;
	private JTextField tfbmarca;
	private JTextField tfbmodelo;
	private JTextField tfbtransmision;
	private JTextField tfbversion;
	private JTextField tfbprecio;
	private JTextField tfbmotor;
	private JTextField tfidbus;
	
	//Automoviles auto1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autos frame = new Autos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Autos() {
		setTitle("Catalogo  de autos");
		tfprecio.setBounds(272, 88, 86, 20);
		tfprecio.setColumns(10);
		tftransmision.setBounds(156, 146, 86, 20);
		tftransmision.setColumns(10);
		tfmotor.setBounds(156, 88, 86, 20);
		tfmotor.setColumns(10);
		tfmodelo.setBounds(16, 146, 86, 20);
		tfmodelo.setColumns(10);
		tfmarca.setBounds(14, 88, 86, 20);
		tfmarca.setColumns(10);
		persona();
		llenarMarca();
		//this.setContentPane(image);
		setResizable(false);
		lblid.setText(String.valueOf(posi));
	    tfid.setText(String.valueOf(posi));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Marca de autos");
		lblNewLabel.setBounds(10, 226, 110, 14);
		contentPane.add(lblNewLabel);
       cbversion.setEnabled(false);
		
       
       BufferedImage foto1;
	   InputStream impu;
	    ImageInputStream image1;
	    BufferedImage image; 
       
       
       cbversion.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				ba=1;
			}
		
		});
		
		cbmarca.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				 cbversion.enable(true);
				llenarversion();
			}
		
		});
		
		
		
		cbmarca.setBounds(10, 251, 110, 22);
		contentPane.add(cbmarca);
		lbMarca.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbMarca.setBounds(16, 55, 74, 22);
		
		contentPane.add(lbMarca);
		lbModelo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbModelo.setBounds(24, 117, 80, 22);
		
		contentPane.add(lbModelo);
		lbMotor.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbMotor.setBounds(156, 55, 80, 22);
		
		contentPane.add(lbMotor);
		lbTransmision.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbTransmision.setBounds(142, 117, 94, 22);
		contentPane.add(lbTransmision);
		llbPrecio.setFont(new Font("Arial Black", Font.PLAIN, 14));
		llbPrecio.setBounds(272, 55, 86, 22);
		
		contentPane.add(llbPrecio);
		
		contentPane.add(tfmarca);
		
		contentPane.add(tfmodelo);
		
		contentPane.add(tfmotor);
		
		contentPane.add(tftransmision);
		
		contentPane.add(tfprecio);
		
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(4, 177, 640, 37);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("CONSULTA  DE AUTOS");
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(4, 7, 628, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("REGISTRO DE AUTOS");
		lblNewLabel_2.setBounds(204, 5, 188, 23);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Cargar Registro");
		btnNewButton.setBounds(444, 8, 138, 23);
		panel_1.add(btnNewButton);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 0, 180, 14);
		
		panel_1.add(lblNewLabel_3);
		lblid.setBounds(64, 14, 40, 23);
		panel_1.add(lblid);
		lblid.setForeground(Color.WHITE);
		lblid.setFont(new Font("Arial Black", Font.PLAIN, 14));
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//posi=autos1.length;
				double precio=0;
				boolean ban1=true;
				
				
				if(tfmodelo.getText().equals("")|| tfmotor.getText().equals("")||tftransmision.getText().equals("")||tfmarca.getText().equals("")||tfversion.getText().equals("")||tfid.getText().equals("")||URLtexto.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Faltan datos por llenar");
				
			
					
				}else {
					
					
					try {
						 precio=Double.valueOf(tfprecio.getText());
						 
					} catch (Exception e2) {
						
						JOptionPane.showMessageDialog(null, "El campo precio tiene que ser numerico");
						ban1=false;
						
						// TODO: handle exception
					}	
					
			if(posi<20 && ban1==true ) {	
			
			
			
			int id=Integer.valueOf(tfid.getText())+1;
			String id1=String.valueOf(id);
			autos1[(posi)]=new Automoviles (tfmodelo.getText().toString(), tfmotor.getText().toString(), tftransmision.getText().toString(), precio, tfmarca.getText().toString(), tfversion.getText().toString(),id1,URLtexto.getText());	
				posi++;
				rellenar(); 
				limpiar();}
			 lblid.setText(String.valueOf(posi));
			 tfid.setText(String.valueOf(posi));
			 
			 for(int i=0; i<posi; i++) {
				  System.out.println(autos1[i].getMarca()+" "+autos1[i].getModelo()+" "+autos1[i].getMotor()+" "+autos1[i].getNumeroSerie()+" "+autos1[i].getPrecio()+" "+autos1[i].getTransmision());
				 
				 
			 }
				
			}}
		});
		
		
		tfversion = new JTextField();
		tfversion.setBounds(272, 146, 86, 20);
		contentPane.add(tfversion);
		tfversion.setColumns(10);
		
		JLabel lblVersin = new JLabel("Versión");
		lblVersin.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblVersin.setBounds(272, 117, 94, 22);
		contentPane.add(lblVersin);
		
		JLabel lblVersion = new JLabel("Version");
		lblVersion.setBounds(160, 226, 110, 14);
		contentPane.add(lblVersion);
		
		
		cbversion.setBounds(156, 251, 103, 22);
		contentPane.add(cbversion);
		lblId.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblId.setBounds(381, 55, 86, 22);
		
		contentPane.add(lblId);

		tfid.setEditable(false);
		tfid.setBounds(368, 88, 86, 20);
		contentPane.add(tfid);
		tfid.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Imagen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					imagabri();
				
				} catch (Exception e2) {
					
				}
				
				File archivo=file.getSelectedFile();
				if(archivo!=null) {
					
					
				}
				
			}
		});
		
		
		btnNewButton_1.setBounds(365, 145, 89, 23);
		contentPane.add(btnNewButton_1);
		cbid.setBounds(381, 251, 86, 22);
		
		contentPane.add(cbid);
		lblId_1.setBounds(381, 226, 68, 14);
		
		contentPane.add(lblId_1);
		
		JButton btnNewButton_2 = new JButton("Cargar ID");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				rellenarid();
			}
		});
		btnNewButton_2.setBounds(269, 251, 89, 23);
		contentPane.add(btnNewButton_2);
		
		tfvmotor = new JTextField();
		tfvmotor.setEnabled(false);
		tfvmotor.setBounds(16, 322, 86, 20);
		contentPane.add(tfvmotor);
		tfvmotor.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Motor");
		lblNewLabel_4.setBounds(26, 297, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Precio");
		lblNewLabel_5.setBounds(156, 297, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		tfvprecio = new JTextField();
		tfvprecio.setEnabled(false);
		tfvprecio.setText("");
		tfvprecio.setBounds(127, 322, 86, 20);
		contentPane.add(tfvprecio);
		tfvprecio.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Transmisión");
		lblNewLabel_6.setBounds(270, 297, 74, 14);
		contentPane.add(lblNewLabel_6);
		
		tfvtransmision = new JTextField();
		tfvtransmision.setEnabled(false);
		tfvtransmision.setBounds(258, 322, 86, 20);
		contentPane.add(tfvtransmision);
		tfvtransmision.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Ver datos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					cargarima(verDatos());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 	
				
			}
		});
		
		
		btnNewButton_3.setBounds(378, 341, 89, 57);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_7 = new JLabel("Budcsar por ID");
		lblNewLabel_7.setBounds(381, 284, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		
		
		
		JLabel lblNewLabel_8 = new JLabel("Marca");
		lblNewLabel_8.setBounds(10, 362, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Modelo");
		lblNewLabel_9.setBounds(74, 362, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Motor");
		lblNewLabel_10.setBounds(137, 362, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("precio");
		lblNewLabel_11.setBounds(190, 362, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Transmision");
		lblNewLabel_12.setBounds(238, 362, 58, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Version");
		lblNewLabel_13.setBounds(320, 362, 46, 14);
		contentPane.add(lblNewLabel_13);
		
		tfbmarca = new JTextField();
		tfbmarca.setEnabled(false);
		tfbmarca.setBounds(10, 387, 50, 20);
		contentPane.add(tfbmarca);
		tfbmarca.setColumns(10);
		
		tfbmodelo = new JTextField();
		tfbmodelo.setEnabled(false);
		tfbmodelo.setBounds(76, 387, 38, 20);
		contentPane.add(tfbmodelo);
		tfbmodelo.setColumns(10);
		
		tfbtransmision = new JTextField();
		tfbtransmision.setEnabled(false);
		tfbtransmision.setBounds(238, 387, 67, 20);
		contentPane.add(tfbtransmision);
		tfbtransmision.setColumns(10);
		
		tfbversion = new JTextField();
		tfbversion.setEnabled(false);
		tfbversion.setBounds(316, 387, 50, 20);
		contentPane.add(tfbversion);
		tfbversion.setColumns(10);
		
		tfbprecio = new JTextField();
		tfbprecio.setEnabled(false);
		tfbprecio.setBounds(184, 387, 46, 20);
		contentPane.add(tfbprecio);
		tfbprecio.setColumns(10);
		
		tfbmotor = new JTextField();
		tfbmotor.setEnabled(false);
		tfbmotor.setBounds(127, 387, 47, 20);
		contentPane.add(tfbmotor);
		tfbmotor.setColumns(10);
		
		tfidbus = new JTextField();
		tfidbus.setBounds(381, 310, 86, 20);
		contentPane.add(tfidbus);
		tfidbus.setColumns(10);
		
		
		panel_2= new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(200);
		flowLayout_1.setHgap(200);
		panel_2.setBounds(103, 274, 29, 37);
		contentPane.add(panel_2);
		
		
		URLtexto.setBounds(408, 219, 209, 29);
		contentPane.add(URLtexto);
		
		panel_3= new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(50);
		flowLayout.setHgap(50);
		panel_3.setBounds(114, 88, 38, 37);
		contentPane.add(panel_3);
		
		 lblImagenOriginal = new JLabel("");
		lblImagenOriginal.setBounds(482, 44, 150, 124);
		contentPane.add(lblImagenOriginal);
		
		lblImagenOriginal1 = new JLabel("");
		lblImagenOriginal1.setBounds(488, 251, 147, 136);
		contentPane.add(lblImagenOriginal1);
		
		
	}
	
	public void cargarima(int a)   {
		String Ruta=autos1[a].getImagen();
		   Image imaico=new ImageIcon(Ruta).getImage();
		    ImageIcon imaOri=new ImageIcon(imaico.getScaledInstance(lblImagenOriginal.getWidth(), lblImagenOriginal.getHeight(),Image.SCALE_SMOOTH));
		  
		   lblImagenOriginal1.setIcon(imaOri);
		   ImageIcon icono;
		     URLtexto.setText(Ruta);	
		     URLtexto.setVisible(false);
		     icono=new ImageIcon(getClass().getResource(Ruta));
		     
		     
		     
		     if(Ruta.length()>=28)
		    	 {System.out.println("hola 2");
		    	 lblImagenOriginal1.setIcon(imaOri);
		    	 }else
		    		 lblImagenOriginal1.setIcon(icono);
		     
		}
	
	
	
	
	public void imagabri() {
		String Ruta;
		
	    JFileChooser AbrirIma=new JFileChooser();
		    FileNameExtensionFilter filter=new FileNameExtensionFilter("jpg,bmp,gif", "jpg","bmp","gif");
		    AbrirIma.setFileFilter(filter);
		    int respuesta=AbrirIma.showOpenDialog(this);
		    if(respuesta==0){
		    Ruta=AbrirIma.getSelectedFile().getPath();
		   Image imaico=new ImageIcon(Ruta).getImage();
		    ImageIcon imaOri=new ImageIcon(imaico.getScaledInstance(lblImagenOriginal.getWidth(), lblImagenOriginal.getHeight(),Image.SCALE_SMOOTH));
		   lblImagenOriginal.setIcon(imaOri);
		     URLtexto.setText(Ruta);
		     //ImageIcon icono=new ImageIcon(getClass().getResource("../Imagenes/fondo.jpg"));
		     //URL dos=URL(Ruta);
		     //URLtexto.setIcon(getClass().getResource());
		     //lblImagenOriginal.setIcon(getClass().getResource("imagenes/icono.png));
		     URLtexto.setVisible(false);	
		     File archivo=AbrirIma.getSelectedFile();
		     try {
		    	 String dest=System.getProperty("user.dir")+"/imagenes/"+archivo.getName();
			     Path Destino=Paths.get(dest);
			     String Orig= archivo.getPath();
			     Path Original= Paths.get(Orig);
			    // Files.copy(Original, Destino, REPLACE_EXISTING );
			     Files.copy(Original, Destino, REPLACE_EXISTING);
			     System.out.println(dest);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		     
		     
		     
		     
		     
		     
		     
		    }
	}
	
	
	public int verDatos() throws MalformedURLException, IOException {
		int dato=0;
		if(tfidbus.getText().equals("")) {
			 indice=cbid.getSelectedIndex();
			for(int j=0; j<posi; j++) {
			 if(autos1[j].getNumeroSerie().equals(cbid.getItemAt(indice)))	{
				 tfvmotor.setText(autos1[j].getMotor());
				 tfvtransmision.setText(autos1[j].getTransmision());
				 tfvprecio.setText(String.valueOf(autos1[j].getPrecio()));
				dato=j;
				j=posi;
			 }
				
			}
		
		}else
			dato=buscarid();
		
		return dato;
	}
	
	public int buscarid() {
		boolean encontre=false;
		int indi=0;
		for(int a=0; a<posi; a++) {
			if(tfidbus.getText().equals(autos1[a].getNumeroSerie())) {
				tfbmotor.setText(autos1[a].getMotor());
				tfbversion.setText(autos1[a].getVersion());
				tfbmarca.setText(autos1[a].getMarca());
				tfbprecio.setText(String.valueOf(autos1[a].getPrecio()));
				tfbtransmision.setText(autos1[a].getTransmision());
				tfbmodelo.setText(autos1[a].getModelo());
				encontre=true;
				indi=a;
				a=posi;
			}
			
		}

		return  indi;	
	}
	
	public void persona() {
		
		autos1[0]=new Automoviles ("2023","302","automatico",125.000,"Nissan","sentra","1","/imagenes/sentra.jpg");
		autos1[1]=new Automoviles ("2023","2.0","Estandar",130.000,"Nissan", "tsuru","2",  "/imagenes/tsusu2023.jpg");
		autos1[2]=new Automoviles ("2023","2.0","Estandar",140.000,"Nissan","Versa","3",   "/imagenes/versa2023.jpg");
		autos1[3]=new Automoviles ("2023","1.6","Estandar",250.000,"Nissan","Mp300","4",   "/imagenes/np300.jpg");
		autos1[4]=new Automoviles ("2023","2.0","Estandar",280.000,"Chevrolet","aveo","5", "/imagenes/ave2023.jpg");
		autos1[5]=new Automoviles ("2023","2.0","Estandar",200.000,"Ford","fiesta","6",    "/imagenes/fiesta.jpg");
		autos1[6]=new Automoviles ("2023","2.0","Estandar",650.000,"Toyota","Tacoma","7",  "/imagenes/tacoma2023.jpg");
		autos1[7]=new Automoviles ("2023","2.0","Estandar",220.000,"ford","fordk","8",     "/imagenes/fordka.jpg");
		
	}

    public void rellenarid() {
	cbid.removeAllItems();
		int indice=cbversion.getSelectedIndex();
	
		for(int j=0; j<posi;  j++) {
			    if(cbversion.getItemAt(indice).equals(autos1[j].getVersion()))	
				cbid.addItem(autos1[j].getNumeroSerie());	
				
	}
 	
	}
	
	public void rellenar() {
		
		cbmarca.repaint();
		boolean existe=false;
		 int elementos=cbmarca.getItemCount();	
			String elemen=tfmarca.getText();
			for(int j=0; j<elementos; j++) {
			if(cbmarca.getItemAt(j).equals(elemen)) {
				existe=true;
			}

		}
	
			if(existe==false) {
			cbmarca.addItem(autos1[posi-1].getMarca());
			cbmarca.repaint();
			}
		}

	public void limpiar() {
		
		tfmodelo.setText("");
		tfmotor.setText("");
		tftransmision.setText("");
		tfprecio.setText("");
		tfmarca.setText("");
		tfversion.setText("");
		tfid.setText("");
	}
	
	public void llenarversion() {
		
		cbversion.removeAllItems();
	    int indice=cbmarca.getSelectedIndex();
		cbversion.addItem("Opción");
		for(int x=0; x<posi;  x++) {
	    if(cbmarca.getItemAt(indice).equals(autos1[x].getMarca())) {		
	    cbversion.addItem(autos1[x].getVersion());
	    	
	    	
	    	
	    }
		}

	}
	
	public void llenarMarca() {
		cbmarca.addItem("Opcion");
	    cbmarca.addItem(autos1[0].getMarca());
			for(int j=0; j<8; j++) {
				 int elementos=cbmarca.getItemCount();	
				for(int i=1; i<elementos; i++) {
					if(cbmarca.getItemAt(i).equals(autos1[j].getMarca())) {
						i=elementos;
						
					}
					else {
						cbmarca.addItem(autos1[j].getMarca());
						i=elementos;
					}
					
				}
		}
			
	}
	
	
	
	public void guadarIma() {}
	
	JFileChooser foto1=new JFileChooser();
	
}



	
	
	
	
	
	
