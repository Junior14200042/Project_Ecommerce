package modelo;

/*codUsu int NOT NULL AUTO_INCREMENT,
Apeusu varchar(30) NOT NULL,
nomUsu varchar(30) NOT NULL,
Ditrito varchar(100) NOT NULL,
perfil varchar(15) NOT NULL,
correo varchar(30) NOT NULL,
claveUsu varchar(30) NOT NULL,*/

public class Usuario {
	private int codUsu;
	private String apeUsu;
	private String nomUsu;
	private String distrito;
	private String perfil;
	private String correo;
	private String claveUsu;
	public Usuario(int codUsu, String apeUsu, String nomUsu, String distrito, String perfil, String correo,
			String claveUsu) {
		this.codUsu = codUsu;
		this.apeUsu = apeUsu;
		this.nomUsu = nomUsu;
		this.distrito = distrito;
		this.perfil = perfil;
		this.correo = correo;
		this.claveUsu = claveUsu;
	}
	public int getCodUsu() {
		return codUsu;
	}
	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}
	public String getApeUsu() {
		return apeUsu;
	}
	public void setApeUsu(String apeUsu) {
		this.apeUsu = apeUsu;
	}
	public String getNomUsu() {
		return nomUsu;
	}
	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClaveUsu() {
		return claveUsu;
	}
	public void setClaveUsu(String claveUsu) {
		this.claveUsu = claveUsu;
	} 
}