package particlesystem;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

import sun.security.krb5.KdcComm;
import util.Vector3D;

import com.sun.opengl.util.GLUT;

public class ParticleSystem {
	List<Particle> particles = new ArrayList<>();

	public ParticleSystem() {
		// TODO Auto-generated constructor stub
		for(int i = -20; i < 20; i+=2)
			for(int j = -5; j < 5; j++)
				for(int k = -5; k < 5; k++){
					particles.add(new Particle(new Vector3D(i, j, k), 1));
				}
					
		
	}

	public void Draw(GL gl, GLU glu, GLUT glut) {
		//particle mat, init once
		float mat_ambient[] = { 0.7f, 0.7f, 0.7f, 1.0f };
		float mat_diffuse[] = { 0.4f, 0.4f, 1.0f, 1.0f};
		float mat_specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		float mat_shininess[] = {50.0f};
	    gl.glTranslatef(-3.75f, 0.0f, 0.0f);
	    gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambient, 0);
	    gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_diffuse, 0);
	    gl.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess, 0);
	    
	    for(Particle particle: particles) particle.Draw(gl, glu, glut);
	}
}