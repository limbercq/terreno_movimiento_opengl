package com.example.terreno;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Superficie1 {
	/**
	 * 3 --------- 2 /| /| / | / | 7 --------- 6 | | | | | | 0 ------|-- 1 | / |
	 * / |/ |/ 4 --------- 5
	 */
	/* Las coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float[] {
			// Frente 
			-4.7f, -6,1.23f, // 4 0
			0, -6, 1.23f, // 5 1
			0, -1, 1.23f, // 6 2
			-9.7f, -1 , 1.23f, // 7 3
			// Atr�s
			-6.95f, -1, -5.23f, // 3 4
			0, -1, -8, // 2 5
			0, -6, -3, // 1 6
			-4.7f, -6, -0.23f, // 0 7
						
			// Izquierda 
			-4.7f, -6, -0.23f, // 0 8 
			-4.7f, -6,1.23f, // 4 9 
			-9.7f, -1,1.23f, // 7 10 
			-6.95f, -1, -5.23f, // 3 11
			// Derecha
			0, -6, 1.23f, // 5 12
			0, -6, -3, // 1 13
			0, -1, -8, // 2 14
			0, -1, 1.23f, // 6 15
			// Abajo
			-4.7f, -6, -0.23f, // 0 16
			0, -6, -3, // 1 17
			0, -6, 1.23f, // 5 18
			-4.7f, -6,1.23f, // 4 19
			// Arriba
			-9.7f, -1,1.23f, // 7 20
			0, -1, 1.23f, // 6 21
			0, -1, -8, // 2 22
			-6.95f, -1, -5.23f, // 3 23
	};

	/* Los colores x c/v�rtice (r,g,b,a) */
	byte maxColor = (byte) 20;
	private byte colores[] = new byte[] {
			// Frente - lila
			// Frente - lila
			maxColor, maxColor, maxColor, maxColor, // 0 8
			maxColor, maxColor, maxColor, maxColor, // 4 9
			maxColor, maxColor, maxColor, maxColor, // 7 10
			maxColor, maxColor, maxColor, maxColor, // 3 11
			// Atr�s - amarillo
			maxColor, maxColor, maxColor, maxColor, // 0 8
			maxColor, maxColor, maxColor, maxColor, // 4 9
			maxColor, maxColor, maxColor, maxColor, // 7 10
			maxColor, maxColor, maxColor, maxColor, // 3 11
			// Izquierda - celeste
			maxColor, maxColor, maxColor, maxColor, // 0 8
			maxColor, maxColor, maxColor, maxColor, // 4 9
			maxColor, maxColor, maxColor, maxColor, // 7 10
			maxColor, maxColor, maxColor, maxColor, // 3 11
			// Derecha - rojo
			maxColor, maxColor, maxColor, maxColor, // 0 8
			maxColor, maxColor, maxColor, maxColor, // 4 9
			maxColor, maxColor, maxColor, maxColor, // 7 10
			maxColor, maxColor, maxColor, maxColor, // 3 11
			// Abajo - azul
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Arriba - verde
			maxColor, maxColor, maxColor, maxColor, // 0 8
			maxColor, maxColor, maxColor, maxColor, // 4 9
			maxColor, maxColor, maxColor, maxColor, // 7 10
			maxColor, maxColor, maxColor, maxColor, // 3 11
	};
	/* Indices */
	private short indices[] = new short[] { 0, 1, 2, 0, 2, 3, // Frente
			4, 5, 6, 4, 6, 7, // Atr�s
			8, 9, 10, 8, 10, 11, // Izquierda
			12, 13, 14, 12, 14, 15, // Derecha
			16, 17, 18, 16, 18, 19, // Abajo
			20, 21, 22, 20, 22, 23 // Arriba
	};
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;

	public Superficie1() {
		/* Lee los v�rtices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte
												// nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer

		/* Lee los colores */
		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0); // puntero al principio del buffer
		/* Lee los indices */
		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte
												// nativo
		bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices.put(indices);
		bufIndices.rewind(); // puntero al principio del buffer
	}

	public void dibuja(GL10 gl) {
		/* Se habilita el acceso al arreglo de v�rtices */
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		/* Se habilita el acceso al arreglo de colores */
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		/* Se especifica los datos del arreglo de v�rtices */
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		/* Se especifica los datos del arreglo de colores */
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
		/* Se dibuja el cubo */
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		/* Se deshabilita el acceso a los arreglos */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
}
