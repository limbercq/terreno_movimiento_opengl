package com.example.terreno;


import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

		private GLSurfaceView superficie;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			/* Ventana sin t�tulo */
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			/* Se establece las banderas de la ventana de esta Actividad */
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
			/* Se crea el objeto Renderiza */
			superficie = new Renderiza(this);
			/*
			 * Activity <- GLSurfaceView : Coloca la Vista de la Superficie del
			 * OpenGL como un Contexto de �sta Actividad.
			 */
			setContentView(superficie);
			// setContentView(R.layout.activity_main);
		}
		/**
		 * Recuerda que debe reanudar superficie
		 */
		@Override
		protected void onResume() {
			super.onResume();
			superficie.onResume();
		}
		/**
		 * Tambi�n pausa la superficie
		 */
		@Override
		protected void onPause() {
			super.onPause();
			superficie.onPause();
		}
	}