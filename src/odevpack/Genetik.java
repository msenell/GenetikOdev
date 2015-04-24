package odevpack;

public class Genetik {

	/**
	 * @param args
	 */
	public static String[] sayilar=new String[6];
	public static int[] degerler=new int[6];
	public static int en=6;
	public static void main(String[] args) {
		char kosul='v';
		Fonksiyonlar f1=new Fonksiyonlar();
		f1.Doldur(sayilar);
		for(int i=0; i<sayilar.length; i++)
			System.out.println(sayilar[i]);
		System.out.println();
		f1.DegerleriBul(sayilar, degerler);
		for(int i=0; i<6; i++) System.out.println(degerler[i]);
		int sayac=0;
		while(kosul=='v')
		{
			f1.Caprazla(sayilar, degerler);
			f1.Mutasyon(sayilar, degerler);
			f1.BaskiniArtir(sayilar, degerler);
			if(!f1.Kosul(degerler)) kosul='v';
			else kosul='x';
			sayac++;
		}
		for(int i=0; i<6; i++)
			System.out.println(sayilar[i]+" = "+degerler[i]);

	}

}
