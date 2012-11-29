package TPCtrl1;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cipher1 crypt = new Cipher1 (2);
		String fichier = new String ("/home/guigui/test/Cipher1.crypt");
		String fichier1 = new String ("/home/guigui/test/tampon.txt");
		String fichier2 = new String ("/home/guigui/test/Cipher1-4.crypt");
		String test=new String("abcd");
		String retour;
		byte[] tampon=test.getBytes();
		byte[] essay;
		essay=crypt.chiffre(tampon);
		Cipher1.affichage(test);
		Cipher1.affiche(essay);
		retour = new String(essay);
		System.out.println("Le cryptage ASCII donne : "+retour);
		System.out.println("Le cryptage ASCII donne : "+crypt.chiffreMsg(test));
		//affiche(essay);
		Cipher1.decryptFichier(fichier,fichier1);
		Cipher1.cryptFichier(fichier1,fichier2);
		System.out.println("hello");
		//TODO l et m
		}

}
