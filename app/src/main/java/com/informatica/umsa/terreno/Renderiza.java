package com.informatica.umsa.terreno;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.view.MotionEvent;

/**
 * Clase Renderiza (OpenGL 1.x)
 * 
 * @author Jhonny Felipez
 * @version 1.0 02/04/2014
 *
 */
public class Renderiza extends GLSurfaceView implements Renderer {

	/* Objeto */
	private Cubo cubo;
	private ParedSobre paredsobre;
	private ParedSobre1 paredsobre1;
	private Puerta puerta;
	private Puerta1 puerta1;
	private Techo techo;
	private Techo1 techo1;
	private PuntaTecho puntatecho;
	private Cubo1 cubo1;
	private Cubo2 cubo2;
	private TechoDere techodere;
	private TechoIzqui techoizqui;
	private Arbol arbol;
	private Arbol1 arbol1;
	private Arbol2 arbol2;
	private Arbol3 arbol3;
	private Arbol4 arbol4;
	private Arbol5 arbol5;
	private Arbol6 arbol6;
	private Arbol7 arbol7;
	private Arbol8 arbol8;
	private Arbol9 arbol9;
	private Arbol10 arbol10;
	private Arbol11 arbol11;
	private Arbol12 arbol12;
	private Arbol13 arbol13;
	private Superficie1 piso;
	private Superficie2 piso1;
	private Superficie3 piso2;
	private Superficie4 piso3;
	private Casita casita;
	private Casa1 casa1;
	private Casa2 casa2;
	private Casa3 casa3;
	private Casa4 casa4;
	
	private Estadium1 estadium1;
	private Estadium2 estadium2;
	private Estadium3 estadium3;
	private Estadium4 estadium4;
	
	
	private Circulo circulo;
	
	private ColoresR coloresR = new ColoresR();
	
	/* Inicializa ubicaci�n de la vista del observador */
	private final float[] vectorEntrada = { 0, 0, -1, 1 };
	private static float posicion[] = { 0, -0.1f, 35 };
	private final float[] direccion = new float[4];

	/* Tama�o de la ventana en pixeles */
	private int alto;
	private int ancho;
	
	/* Para la rotaci�n y traslaci�n */
	private float rotY;
	private	float antX;
	
	final float[] matriz = new float[16];
	
	/* Contexto */
	Context contexto;
	
	public Renderiza(Context contexto) {
		super(contexto);
		this.contexto = contexto;
		this.setRenderer(this);
		this.requestFocus();
		this.setFocusableInTouchMode(true);
		this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		
		cubo = new Cubo();
		paredsobre =new ParedSobre();
		paredsobre1 =new ParedSobre1();
		puerta = new Puerta();
		puerta1 = new Puerta1();
		techo = new Techo();
		techo1 = new Techo1();
		puntatecho = new PuntaTecho();
		cubo1 = new Cubo1();
		cubo2 = new Cubo2();
		techodere = new TechoDere();
		techoizqui = new TechoIzqui();
		arbol = new Arbol();
		arbol1 = new Arbol1();
		arbol2 = new Arbol2();
		arbol3 = new Arbol3();
		arbol4 = new Arbol4();
		arbol5 = new Arbol5();
		arbol6 = new Arbol6();
		arbol7 = new Arbol7();
		arbol8 = new Arbol8();
		arbol9 = new Arbol9();
		arbol10 = new Arbol10();
		arbol11 = new Arbol11();
		arbol12 = new Arbol12();
		arbol13 = new Arbol13();
		piso = new Superficie1();
		piso1 = new Superficie2();
		piso2 = new Superficie3();
		piso3 = new Superficie4();
		casita =new Casita();
		casa1= new Casa1();
		casa2= new Casa2();
		casa3=new Casa3(coloresR.colorVerde);
		casa4=new Casa4(coloresR.colorAzul);
		estadium1=new Estadium1();
		estadium2=new Estadium2();
		estadium3=new Estadium3();
		estadium4=new Estadium4();
		
		circulo = new Circulo(0.5f, 360, true);
        
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glClearColor(176/255f, 196/255f, 222/256f, 0);

	}
	
	@Override
	public void onDrawFrame(GL10 gl) {

		/* Borra el buffer de la ventana y del z-buffer */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		/* Botones de las opciones */
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrthof(-4, 4, -6, 6, 1, 100);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		
		
		
		
		
		// Bot�n avanza
		gl.glPushMatrix();
		gl.glTranslatef(0, -4, 0);
		circulo.dibuja(gl);
		gl.glPopMatrix();
		
		
		
		
		
		// Bot�n retrocede
		gl.glPushMatrix();
		gl.glTranslatef(0, -5.5f, 0);
		circulo.dibuja(gl);
		gl.glPopMatrix();
		
		
		
		
		
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 67, ancho / (float)alto, 1f, 100f);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glRotatef(-rotY, 0, 1, 0);
		gl.glTranslatef(-posicion[0], -posicion[1], -posicion[2]);
		
		
		gl.glPushMatrix();
		gl.glTranslatef(-5, 0, 5);
		gl.glRotatef(270, 180, 1, 1);	
		casita.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-5, 0, 20);
		gl.glRotatef(270, 180, 1, 1);	
		casita.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(8, -1, 8);
		gl.glScalef(-1, 1, -1);
		gl.glRotatef(270, 180, 1, 1);	
		casa1.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-5, -1, 12);
		gl.glScalef(1, 1, 1);
		gl.glRotatef(270, 180, 1, 1);	
		casa2.dibuja(gl);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glTranslatef(-5, -1, 17);
		gl.glScalef(1, 1, 1);
		gl.glRotatef(270, 180, 1, 1);	
		casa3.dibuja(gl);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glTranslatef(5, -1, 20);
		gl.glScalef(1, 1, 1);
	
		casa3.dibuja(gl);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glTranslatef(5, -1, 25);
		gl.glScalef(1, 1, 1);
			
		casa4.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-15, 4, 5);
		gl.glScalef(1, 1, 1);
		estadium1.dibuja(gl);
		gl.glPopMatrix();
		

		gl.glPushMatrix();
		gl.glTranslatef(-15, 4, 5);
		gl.glScalef(1, 1, 1);
		estadium2.dibuja(gl);
		gl.glPopMatrix();
		

		gl.glPushMatrix();
		gl.glTranslatef(-15, 4, 5);
		gl.glScalef(1, 1, 1);
		estadium3.dibuja(gl);
		gl.glPopMatrix();
		

		gl.glPushMatrix();
		gl.glTranslatef(-15, 4, 5);
		gl.glScalef(1, 1, 1);
		estadium4.dibuja(gl);
		gl.glPopMatrix();
		

		paredsobre.dibuja(gl); // P' = MVM * P
	

		paredsobre1.dibuja(gl); // P' = MVM * P	


		puerta.dibuja(gl); // P' = MVM * P
		

		puerta1.dibuja(gl); // P' = MVM * P
		

		techo.dibuja(gl); // P' = MVM * P
		

		techo1.dibuja(gl); // P' = MVM * P
		

		puntatecho.dibuja(gl); // P' = MVM * P
		

		cubo1.dibuja(gl); // P' = MVM * P
		

		cubo2.dibuja(gl); // P' = MVM * P
		

		techodere.dibuja(gl); // P' = MVM * P
		
		

		techoizqui.dibuja(gl); // P' = MVM * P
		
		

		arbol.dibuja(gl); // P' = MVM * P
		
		

		arbol1.dibuja(gl); // P' = MVM * P
		
		

		arbol2.dibuja(gl); // P' = MVM * P
		
		

		arbol3.dibuja(gl); // P' = MVM * P
		
		

		arbol4.dibuja(gl); // P' = MVM * P
		
		

		arbol5.dibuja(gl); // P' = MVM * P
		
		

		arbol6.dibuja(gl); // P' = MVM * P
		
		

		arbol7.dibuja(gl); // P' = MVM * P
		
		

		arbol8.dibuja(gl); // P' = MVM * P
		
		

		arbol9.dibuja(gl); // P' = MVM * P
		
		

		arbol10.dibuja(gl); // P' = MVM * P
		
		

		arbol11.dibuja(gl); // P' = MVM * P
		
		

		arbol12.dibuja(gl); // P' = MVM * P
		
		

		arbol13.dibuja(gl); // P' = MVM * P
		
		

		gl.glPushMatrix();
		gl.glScalef(5, 1, 5);
		piso.dibuja(gl); // P' = MVM * P
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glScalef(5, 1, 5);
		piso1.dibuja(gl); // P' = MVM * P
		gl.glPopMatrix();
		

		gl.glPushMatrix();
		gl.glScalef(5, 1, 5);
		piso2.dibuja(gl); // P' = MVM * P
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glScalef(5, 1, 5);
		piso3.dibuja(gl); // P' = MVM * P
		gl.glPopMatrix();

		cubo.dibuja(gl); // P' = MVM * P
		
	
		

		gl.glFlush();

	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {
		
		ancho = w;
		alto = h;
		
		gl.glViewport(0, 0, ancho, alto);
		
		GLU.gluLookAt(gl, 0, 0, 0, 0, 0, -1, 0, 1, 0);

	}
	
	/**
	 * Maneja los eventos del movimiento en la pantalla t�ctil. 
	 */
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		
		/* Obtiene la coordenada de la pantalla */
		float posx = e.getX();
		float posy = e.getY();
		
		/* Se considera cuando se levanta el dedo de la pantalla. */ 
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			
			/* En coordenadas del OpenGL */
			posx = ((posx / (float) ancho) * 8) - 4;
			posy = ((1 - posy / (float) alto) * 12) - 6;

			/* Verifica �rea elegida */
			if (puntoEstaDentroDelCirculo(posx, posy, 0, -4f, 0.5f)) { // Avanza
				Matrix.setIdentityM(matriz, 0);
				Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
				Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);
				
				posicion[0] = posicion[0] + direccion[0] * 0.5f;
				posicion[1] = posicion[1] + direccion[1] * 0.5f;
				posicion[2] = posicion[2] + direccion[2] * 0.5f;
				
			} else if (puntoEstaDentroDelCirculo(posx, posy, 0, -5.5f, 0.5f)) { // Retrocede
				Matrix.setIdentityM(matriz, 0);
				Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
				Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);
				
				posicion[0] = posicion[0] - direccion[0] * 0.5f;
				posicion[1] = posicion[1] - direccion[1] * 0.5f;
				posicion[2] = posicion[2] - direccion[2] * 0.5f;
			}
			requestRender();
		} else if (e.getAction() == MotionEvent.ACTION_MOVE) {
			if(antX == -1) {
				antX = posx;
			} else {							
				rotY = rotY + (posx - antX) / 10;
				antX = posx;
			}
			
			requestRender();
		} else { 
			antX = -1;
		}	
		return true;
	}
	
	private boolean puntoEstaDentroDelCirculo(float posx, float posy, float x,
			float y, float radio) {
		return (distancia2(posx, posy, x, y) < radio * radio);
	}

	public float distancia2(float x1, float y1, float x2, float y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
