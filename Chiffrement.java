package TPCtrl1;
public interface Chiffrement {
	
	public byte[] chiffre(byte[] msg);
	public String chiffreMsg(String msg);
	
	public byte[] dechiffre(byte[] cipher);
	public String dechiffreMsg(String msg);
}
