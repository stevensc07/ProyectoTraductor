package pkgfinal;

/*-----------------------------------------------------------------------------------------------------------------------------------------------------*/
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
// khaaaaa? por que no te borrass????
/*-----------------------------------------------------------------------------------------------------------------------------------------------------*/
public class Diccionario extends javax.swing.JFrame {

    public Diccionario() {

        initComponents();
        traduce_to_Español[0] = "amigo";
        traduce_to_Español[2] = "casa";
        traduce_to_Español[3] = "gato";
        traduce_to_Español[4] = "perro";
        traduce_to_Español[5] = "abuela";
        traduce_to_Español[6] = "mama";
        traduce_to_Español[7] = "papa";
        traduce_to_Español[8] = "puerta";
        traduce_to_Español[9] = "silla";
        traduce_to_Español[10] = "comer";
        traduce_to_Español[11] = "hacer";
        traduce_to_Español[12] = "pelota";
        traduce_to_Español[13] = "lapiz";
        traduce_to_Español[14] = "boligrafo";
        traduce_to_Español[15] = "borrador";
        traduce_to_Español[16] = "cuaderno";
        traduce_to_Español[17] = "hola";
        traduce_to_Español[18] = "arbol";
        traduce_to_Español[19] = "el";
        traduce_to_Español[20] = "ella";
        traduce_to_Español[21] = "nosotros";
        traduce_to_Español[22] = "ser";
        traduce_to_Español[23] = "ayuda";
        traduce_to_Español[24] = "zorro";
        traduce_to_Español[25] = "vaca";
        /*-----------------------------------------------------------------------*/
        traduce_to_Ingles[0] = "friend";
        traduce_to_Ingles[1] = "read";
        traduce_to_Ingles[2] = "house";
        traduce_to_Ingles[3] = "cat";
        traduce_to_Ingles[4] = "dog";
        traduce_to_Ingles[5] = "grandmother";
        traduce_to_Ingles[6] = "mother";
        traduce_to_Ingles[7] = "father";
        traduce_to_Ingles[8] = "door";
        traduce_to_Ingles[9] = "chair";
        traduce_to_Ingles[10] = "eat";
        traduce_to_Ingles[11] = "do";
        traduce_to_Ingles[12] = "ball";
        traduce_to_Ingles[13] = "pencil";
        traduce_to_Ingles[14] = "pen";
        traduce_to_Ingles[15] = "eraser";
        traduce_to_Ingles[16] = "notebook";
        traduce_to_Ingles[17] = "hello";
        traduce_to_Ingles[18] = "tree";
        traduce_to_Ingles[19] = "he";
        traduce_to_Ingles[20] = "she";
        traduce_to_Ingles[21] = "we";
        traduce_to_Ingles[22] = "be";
        traduce_to_Ingles[23] = "help";
        traduce_to_Ingles[24] = "fox";
        traduce_to_Ingles[25] = "cow";
        n = 25;
    }
private SecretKey key;       
    private Cipher cipher;  
    private String algoritmo= "AES";
    private int keysize=16;
    public void addKey( String value ){
        byte[] valuebytes = value.getBytes();            
        key = new SecretKeySpec( Arrays.copyOf( valuebytes, keysize ) , algoritmo );      
    }

     /**
 * Metodo para encriptar un texto
 * @param String texto
 * @return String texto encriptado
 */
    public String encriptar( String texto ){
        String value="";
        try {
            cipher = Cipher.getInstance( algoritmo );             
            cipher.init( Cipher.ENCRYPT_MODE, key );             
            byte[] textobytes = texto.getBytes();
            byte[] cipherbytes = cipher.doFinal( textobytes );
            value = new BASE64Encoder().encode( cipherbytes );
        } catch (NoSuchAlgorithmException ex) {
            System.err.println( ex.getMessage() );
        } catch (NoSuchPaddingException ex) {
            System.err.println( ex.getMessage() );
        } catch (InvalidKeyException ex) {
            System.err.println( ex.getMessage() );
        } catch (IllegalBlockSizeException ex) {
            System.err.println( ex.getMessage() );
        } catch (BadPaddingException ex) {
            System.err.println( ex.getMessage() );
        }
        return value;
    }


    public String desencriptar( String texto ){
        String str="";
        
        try {
            byte[] value = new BASE64Decoder().decodeBuffer(texto);                 
            cipher = Cipher.getInstance( algoritmo );            
            cipher.init( Cipher.DECRYPT_MODE, key );
            byte[] cipherbytes = cipher.doFinal( value );
            str = new String( cipherbytes );                                  
        } catch (InvalidKeyException ex) {
            System.err.println( ex.getMessage() );
        }  catch (IllegalBlockSizeException ex) {
            System.err.println( ex.getMessage() );
        } catch (BadPaddingException ex) {
            System.err.println( ex.getMessage() );            
        }   catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }catch (NoSuchAlgorithmException ex) {
            System.err.println( ex.getMessage() );
        } catch (NoSuchPaddingException ex) {
            System.err.println( ex.getMessage() );
        }
        return str;
    }
    
    public static void agregar(String Spanish[], String Ingles[], String tama, int n, String nueva, String nuevae) {

        Ingles[n + 1] = nueva;
        Spanish[n + 1] = nuevae;
        int tama2 = Integer.parseInt(tama);
        tama2 = tama2 - 1;
        tama = Integer.toString(tama2);
        limite.setText(tama);
        JOptionPane.showMessageDialog(null, "La palabra se ha agregado al diccionario");

    }

    public static String devolver(int n, String xyz, String English[], String Español[]) {
        int sw = 0,
                i = 0;
        String resultado = " ";
        while (i <= n && sw == 0) {
            if (xyz.equals(English[i])) {
                resultado = Español[i];
                sw = 1;
            } else {
                i = i + 1;
            }
        }
        return (resultado);

    }

    public static String Cifrar(String cade, String clave, String Abcedario) {
        String salida = " ";

        char[] claveEquals = new char[cade.length()];
        char[] Msj = cade.toUpperCase().toCharArray();
        int cont = 0;
        for (int c = 0; c < cade.length(); c++) {

            if (cade.charAt(c) == ' ') {
                c++;
            }
            claveEquals[c] = clave.charAt(cont);
            cont++;
            if (cont == clave.length()) {
                cont = 0;
            }
        }//
        int x = 0, y = 0, z = 0;
        for (int c = 0; c < cade.length(); c++) {
            if (cade.charAt(c) == ' ') {
                salida += " ";
                c++;
            }
            for (int f = 0; f < Abcedario.length(); f++) {
                if (Msj[c] == Abcedario.charAt(f)) {
                    x = f;

                }
                if (claveEquals[c] == Abcedario.charAt(f)) {
                    y = f;

                }

            }
            z = (x + y) % 27;
            salida += Abcedario.charAt(z);

        }

        return salida;
    }

    public static String Descifrar(String Mensaje, String Abcedario,String cla) {
        String salida = "";
        String mayuscula = cla;
       
       
        String clave = mayuscula.toUpperCase();
        char[] claveEquals = new char[Mensaje.length()];
        char[] Msg = Mensaje.toUpperCase().toCharArray();
        int cont = 0;
        for (int c = 0; c < Mensaje.length(); c++) {

            if (Mensaje.charAt(c) == ' ') {
                c++;
            }
            claveEquals[c] = clave.charAt(cont);
            cont++;
            if (cont == clave.length()) {
                cont = 0;
            }
        }
        cont = 0;
        int x = 0, y = 0, z;
        for (int c = 0; c < Mensaje.length(); c++) {
            if (Mensaje.charAt(c) == ' ') {
                salida += " ";
                c++;
            }
            for (int f = 0; f < Abcedario.length(); f++) {
                if (Msg[c] == Abcedario.charAt(f)) {
                    x = f;

                }
                if (claveEquals[c] == Abcedario.charAt(f)) {
                    y = f;

                }

            }
            z = (y - x);

            if (z <= 0) {
                if (z == 0) {
                    salida += "A";
                } else {
                    int o = 1;
                    int sw400 = 0;
                    while (o >= 1 && o <= Abcedario.length() && sw400 == 0) {
                        cont++;
                        if (cont == (z * -1)) {
                            salida += Abcedario.charAt(o);
                            sw400 = 1;
                        }
                        o++;
                    }

                }

            } else {
                int pr = 26;
                int sw401 = 0;
                while (pr <= 26 && pr >= 0 && sw401 == 0) {
                    cont++;
                    if (cont == z) {
                        salida += Abcedario.charAt(pr);
                        sw401 = 1;
                    }
                    pr--;
                }

            }

            cont = 0;

        }

        return salida;
    }

    public static String MetodoBinario(String ch) {
        String bin, totalbin;
        int x = 0;
        totalbin = "";
        for (int i = 0; i < ch.length(); i++) {
            x = ch.charAt(i);
            bin = Integer.toBinaryString(x);
            totalbin = totalbin + " " + bin;
        }
        return (totalbin);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        Escribapalabra = new javax.swing.JLabel();
        palabra = new javax.swing.JTextField();
        Traduccion = new javax.swing.JLabel();
        Opcion = new javax.swing.JComboBox<>();
        TraducirDe = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        traduccion = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        button2 = new java.awt.Button();
        encriptar = new javax.swing.JButton();
        desencriptar = new javax.swing.JButton();
        Desencriptamiento = new javax.swing.JLabel();
        desencrip = new javax.swing.JLabel();
        limite = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escribapalabra.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Escribapalabra.setText("Escriba Palabra");

        palabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palabraActionPerformed(evt);
            }
        });
        palabra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                palabraKeyTyped(evt);
            }
        });

        Traduccion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Traduccion.setText("Traduccion");

        Opcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "        ", "Ingles a Español", "Español a Ingles" }));
        Opcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionActionPerformed(evt);
            }
        });

        TraducirDe.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        TraducirDe.setText("Traducir de :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DICCIONARIO");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/picasion.com_e25e6594a5c93846fcd7b4eeda8c32e8.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");

        traduccion.setBackground(new java.awt.Color(255, 255, 255));
        traduccion.setOpaque(true);

        Add.setText("AGREGAR");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Atras.setText("REGRESAR");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });

        jLabel5.setText("LIMITE:");

        button2.setBackground(new java.awt.Color(51, 153, 255));
        button2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        button2.setLabel("?");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        encriptar.setText("ENCRIPTAR");
        encriptar.setEnabled(false);
        encriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encriptarActionPerformed(evt);
            }
        });

        desencriptar.setText("DESENCRIPTAR");
        desencriptar.setEnabled(false);
        desencriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desencriptarActionPerformed(evt);
            }
        });

        Desencriptamiento.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Desencriptamiento.setText("Desencriptamiento");

        desencrip.setBackground(new java.awt.Color(255, 255, 255));
        desencrip.setOpaque(true);

        limite.setBackground(new java.awt.Color(255, 255, 255));
        limite.setOpaque(true);

        jButton1.setText("LIMPIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Escribapalabra)
                                    .addComponent(TraducirDe)
                                    .addComponent(Traduccion))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(palabra, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(traduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Desencriptamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(desencrip, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Atras)
                        .addGap(406, 406, 406)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(encriptar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(desencriptar)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(limite, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(Escribapalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(TraducirDe)
                        .addGap(41, 41, 41)
                        .addComponent(Traduccion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(palabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(39, 39, 39)
                        .addComponent(Opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(traduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(encriptar)
                            .addComponent(jButton1))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desencriptar)
                            .addComponent(Add)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Desencriptamiento)
                            .addComponent(desencrip, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(limite, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Atras)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String[] traduce_to_Español = new String[100];
    String[] traduce_to_Ingles = new String[100];
    int n;
    String k, m, q, z, pc, mensaje, resultado, p1, p2, p3, p4;
    String Abcedario = "AZBYCXDWEVFUGTHSIRJQKPLOMÑN";
    String cifradoB, cifradoV, cl,cl1;

    private void OpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionActionPerformed
        String cad = palabra.getText();
        StringTokenizer st = new StringTokenizer(cad, ",");
        p1 = "";
        p2 = "";
        p3 = "";
        p4 = "";
        if (st.countTokens() > 4 || st.countTokens() < 1) {
            JOptionPane.showMessageDialog(null, "Numero de palabras no valido. Deben ser maximo 4");
        } else {
            String[] busqueda = cad.split(",");
            if (st.countTokens() == 1) {
                p1 = busqueda[0];
                p1 = p1.toLowerCase();
                p1 = p1.trim();
            } else if (st.countTokens() == 2) {
                p1 = busqueda[0];
                p1 = p1.toLowerCase();
                p1 = p1.trim();
                p2 = busqueda[1];
                p2 = p2.toLowerCase();
                p2 = p2.trim();
            } else if (st.countTokens() == 3) {
                p1 = busqueda[0];
                p1 = p1.toLowerCase();
                p1 = p1.trim();
                p2 = busqueda[1];
                p2 = p2.toLowerCase();
                p2 = p2.trim();
                p3 = busqueda[2];
                p3 = p3.toLowerCase();
                p3 = p3.trim();
            } else if (st.countTokens() == 4) {
                p1 = busqueda[0];
                p1 = p1.toLowerCase();
                p1 = p1.trim();
                p2 = busqueda[1];
                p2 = p2.toLowerCase();
                p2 = p2.trim();
                p3 = busqueda[2];
                p3 = p3.toLowerCase();
                p3 = p3.trim();
                p4 = busqueda[3];
                p4 = p4.toLowerCase();
                p4 = p4.trim();
            }
            int eleccion = Opcion.getSelectedIndex();
            switch (eleccion) {
                case 0:
                    break;
                case 1:
                    (encriptar).setEnabled(true);
                    k = devolver(n, p1, traduce_to_Ingles, traduce_to_Español);
                    m = devolver(n, p2, traduce_to_Ingles, traduce_to_Español);
                    q = devolver(n, p3, traduce_to_Ingles, traduce_to_Español);
                    z = devolver(n, p4, traduce_to_Ingles, traduce_to_Español);
                    if (k.equals(" ") && m.equals(" ") && q.equals(" ") && z.equals(" ")) {
                        encriptar.setEnabled(false);
                        int agregar = JOptionPane.showConfirmDialog(null, "La palabra no se encuentra en el diccionario. Desea agregarla?");
                        if (agregar == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Presione el boton agregar");

                        } else if (agregar == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Ok");
                        }
                    } else if (k.equals(" ") && m.equals(" ") && q.equals(" ")) {
                        encriptar.setEnabled(false);
                        int agregar = JOptionPane.showConfirmDialog(null, "La palabra no se encuentra en el diccionario. Desea agregarla?");

                        if (agregar == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Presione el boton agregar");
                        } else if (agregar == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Ok");
                        }
                    } else if (k.equals(" ") && m.equals(" ")) {
                        encriptar.setEnabled(false);
                        int agregar = JOptionPane.showConfirmDialog(null, "La palabra no se encuentra en el diccionario. Desea agregarla?");

                        if (agregar == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Presione el boton agregar");
                        } else if (agregar == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Ok");
                        }
                    } else if (k.equals(" ")) {

                    } else {
                        traduccion.setText("1." + k + " " + "2." + m + " " + "3." + q + " " + "4." + z);
                    }
                    eleccion = 0;
                    break;
                case 2:
                    (encriptar).setEnabled(true);
                    k = devolver(n, p1, traduce_to_Español, traduce_to_Ingles);
                    m = devolver(n, p2, traduce_to_Español, traduce_to_Ingles);
                    q = devolver(n, p3,traduce_to_Español , traduce_to_Ingles);
                    z = devolver(n, p4,traduce_to_Español , traduce_to_Ingles);
                    if (k.equals(" ") && m.equals(" ") && q.equals(" ") && z.equals(" ")) {
                        encriptar.setEnabled(false);
                        int agregar = JOptionPane.showConfirmDialog(null, "La palabra no se encuentra en el diccionario. Desea agregarla?");
                        if (agregar == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Presione el boton agregar");
                        } else if (agregar == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Ok");
                        }
                    } else if (k.equals(" ") && m.equals(" ") && q.equals(" ")) {
                        encriptar.setEnabled(false);
                        int agregar = JOptionPane.showConfirmDialog(null, "La palabra no se encuentra en el diccionario. Desea agregarla?");
                        if (agregar == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Presione el boton agregar");
                        } else if (agregar == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Ok");
                        }
                    } else if (k.equals(" ") && m.equals(" ")) {
                        encriptar.setEnabled(false);
                        int agregar = JOptionPane.showConfirmDialog(null, "La palabra no se encuentra en el diccionario. Desea agregarla?");
                        if (agregar == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Presione el boton agregar");
                        } else if (agregar == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Ok");
                        }
                    } else {
                        traduccion.setText("1." + k + " " + "2." + m + " " + "3." + q + " " + "4." + z);
                    }

            }

        }
    }//GEN-LAST:event_OpcionActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        String tama = limite.getText();
        if (tama.equals("0")) {
            JOptionPane.showMessageDialog(null, "Diccionario lleno", "ERROR", ERROR_MESSAGE);
        } else {
            String nuevae, nueva;
            nuevae = JOptionPane.showInputDialog(null, "Digite palabra en español");
            nueva = JOptionPane.showInputDialog(null, "Digite palabra en ingles");
            int sw = 0;
            int i = 0;
            int puede = 0;

            while (i <= n && sw == 0) {
                if (nuevae.equals(traduce_to_Español[i]) || nueva.equals(traduce_to_Ingles[i])) {
                    sw = 1;
                } else {
                    i++;
                }
            }
            if (sw == 1 && tama.equals("0")) {
                JOptionPane.showMessageDialog(null, "No puede agregar mas palabras");
                puede = 1;
            }
            if (sw == 0 && puede == 0) {
                agregar(traduce_to_Español, traduce_to_Ingles, tama, n, nueva, nuevae);
                n = n + 1;
                if (tama.equals("11")) {
                    JOptionPane.showMessageDialog(null, "Le restan 10 espacios libres");
                }
                if (tama.equals("6")) {
                    JOptionPane.showMessageDialog(null, "Le restan 5 espacios libres");
                }
                if (tama.equals("2")) {
                    JOptionPane.showMessageDialog(null, "Le restan 1 espacios libres");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La palabra ya se encuentra guardada", "ERROR", ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_AddActionPerformed

    private void palabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palabraActionPerformed

    }//GEN-LAST:event_palabraActionPerformed

    private void palabraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_palabraKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se pueden escribir numeros", "ERROR", ERROR_MESSAGE);
            palabra.setCursor(null);
        }
    }//GEN-LAST:event_palabraKeyTyped

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        JOptionPane.showMessageDialog(null, "Puede ingresar unicamente palabras separadas por comas y maximo 4.Si en la traduccion encuentra"
                + " un espacio al lado de un numero la palabra no se encuentra y si desea puede agregarla.");
    }//GEN-LAST:event_button2ActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        Tamaño ventana1 = new Tamaño();
        ventana1.setVisible(true);
        ventana1.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_AtrasActionPerformed

    private void encriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encriptarActionPerformed
        String mayuscula = JOptionPane.showInputDialog(null, "DIGITE LA PALABRA CLAVE");
        String clave = mayuscula.toUpperCase();
        cl=mayuscula;
        if (m.equals(" ")) {
            mensaje = k;
        } else if (q.equals(" ")) {
            mensaje = k + " " + m;
        } else if (z.equals(" ")) {
            mensaje = k + " " + m + " " + q;

        } else {
            mensaje = k + " " + m + " " + q + " " + z;
        }

        cifradoV = (Cifrar(mensaje, clave, Abcedario));
        
         
       
         String nuestro = cifradoV;
          Diccionario sec = new Diccionario();
        sec.addKey(cl);
        String texto = sec.encriptar(nuestro);
           resultado = MetodoBinario(texto);
        cifradoB = resultado;     
        JOptionPane.showMessageDialog(null, "El cifrado vigenere de su palabra  es:" + cifradoV + "\n el cifrado personal es :  "+ texto + "\n EL codigo binario de su encriptacion es :" +"\n"+ cifradoB);
        traduccion.setText("");
        desencriptar.setEnabled(true);
    }//GEN-LAST:event_encriptarActionPerformed

    private void desencriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desencriptarActionPerformed
       String binCadena="01001000 01001111 01001100 01000001", a="";

for(String s : binCadena.split(" ")){ 
     a+=String.valueOf((char)Integer.parseInt(s, 2));
}

      mensaje = cifradoV ;
        String mayuscula = JOptionPane.showInputDialog(null, "DIGITE LA PALABRA CLAVE");
        cl1=mayuscula;
        if (cl.equals(cl1)) {
            desencrip.setText(Descifrar(mensaje, Abcedario,mayuscula));
        traduccion.setText(desencrip.getText());
        encriptar.setEnabled(false);
        }else{
             JOptionPane.showMessageDialog(null, "CLAVE ERRONEA, INTENTELO NUEVAMENTE", "ERROR", ERROR_MESSAGE);
        }
        
        

    }//GEN-LAST:event_desencriptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         palabra.setText("");

        desencrip.setText("");
        traduccion.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Diccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Diccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Diccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Diccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Diccionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Add;
    private javax.swing.JButton Atras;
    private javax.swing.JLabel Desencriptamiento;
    private javax.swing.JLabel Escribapalabra;
    private javax.swing.JComboBox<String> Opcion;
    private javax.swing.JLabel Traduccion;
    private javax.swing.JLabel TraducirDe;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel desencrip;
    private javax.swing.JButton desencriptar;
    private javax.swing.JButton encriptar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel limite;
    private javax.swing.JTextField palabra;
    private javax.swing.JLabel traduccion;
    // End of variables declaration//GEN-END:variables
}
