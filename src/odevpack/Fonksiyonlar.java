package odevpack;

import java.util.Random;

public class Fonksiyonlar {
	Random fill=new Random();
	int[] c=new int[4];
	
	public void Doldur(String[] s)
	{
		for(int i=0; i<s.length; i++)
		{
			s[i]=String.valueOf(fill.nextInt(2));
			for(int j=1; j<Genetik.en; j++)
			{
				s[i]=s[i]+fill.nextInt(2);
			}
		}
	}
	
	public void DegerleriBul(String[] s, int[] d)
	{
		int temp=0;
		for(int i=0; i<s.length; i++)
		{
			for(int j=0; j<Genetik.en; j++)
			{
				if(s[i].charAt(j)=='1') temp=temp+(int)Math.pow(2, j);
			}
			d[i]=temp;
			temp=0;
		}
	}
	
	public void Caprazla(String[] s, int[] d)
	{
		int i=0;
		int yer;
		while(i<4)
		{
			c[i]=fill.nextInt(6);
			for(int j=0; j<i; j++)
			{
				while(c[i]==c[j])
				{
					c[i]=fill.nextInt(6);
				}
			}
			i++;
		}
		i=0;
		while((yer=fill.nextInt(Genetik.en-1))<2)
		{   }
		String temp1, temp2;
		temp1=s[c[0]].substring(0,yer);
		temp2=s[c[0]].substring(yer, Genetik.en);
		temp1=temp1+s[c[1]].substring(yer,Genetik.en);
		s[c[0]]=temp1;
		temp1=s[c[1]].substring(0,yer);
		temp1=temp1+temp2;
		s[c[1]]=temp1;
		while((yer=fill.nextInt(Genetik.en-1))<2)
		{   }
		temp1=s[c[2]].substring(0,yer);
		temp2=s[c[2]].substring(yer, Genetik.en);
		temp1=temp1+s[c[3]].substring(yer, Genetik.en);
		s[c[2]]=temp1;
		temp1=s[c[3]].substring(0,yer);
		temp1=temp1+temp2;
		s[c[3]]=temp1;	
		DegerleriBul(s, d);
	}
	
	public void Mutasyon(String[] s, int[] d)
	{
		boolean dongu=true;
		int yer, index=-1;
		yer=fill.nextInt(Genetik.en);
		while(dongu)
		{
			dongu=false;
			index=fill.nextInt(s.length);
			for(int i=0; i<Genetik.en-4; i++)
			{
				if(index==c[i]) dongu=true;
			}
		}
		String temp;
		temp=s[index].substring(0,yer);
		if(s[index].charAt(yer)=='1') temp=temp+"0";
		else temp=temp+"1";
		temp=temp+s[index].substring(yer+1,Genetik.en);
		DegerleriBul(s, d);
	}

	public void BaskiniArtir(String[] s, int[] d)
	{
		DegerleriBul(s, d);
		for(int i=0; i<6; i++)
			System.out.println("  "+s[i]+"   "+d[i]);
		int[] asal=new int[6];
		int[] buyuk= new int[6];
		int max, min, mxi=0, mni=0;
		
		for(int i=0; i<6; i++)
		{
			asal[i]=-1;
			buyuk[i]=-1;
		}
		
		for(int i=0; i<6; i++)
		{
			if(AsalMi(d[i])==true) asal[i]=d[i];
			else buyuk[i]=d[i];
		}
		max=asal[0];
		min=buyuk[0];
		int a,b;
		for(a=0; a<6; a++)
		{
			if(asal[a]!=-1)
			{
				max=asal[a];
				mxi=a;
			}
			break;
		}
		/*for(b=0; b<6; b++)
		{
			if(buyuk[b]!=-1)
			{
				min=buyuk[b];
				mni=b;
			}
			break;
		}*/
		for(int i=a; i<6; i++)
		{
			if((max<asal[i])&&(asal[i]!=-1)) 
			{
				mxi=i;
				max=asal[i];
			}
		}/*
		for(int i=b; i<6; i++)
		{
			if((buyuk[i]!=-1))
			{
				mni=i;
				min=buyuk[i];
			}
		}*/
		mni=0;
		min=d[0];
		for(int i=0; i<6; i++)
		{
			if(min>d[i]||d[i]>61)
			{
				min=d[i];
				mni=i;
				break;
			}
		}
		s[mni]=s[mxi];
		d[mni]=d[mxi];
		for(int i=0; i<6; i++) System.out.println(s[i]+"  "+d[i]);
	}

	public boolean Kosul(int[] d)
	{
		boolean kosul=true;
		for(int i=0; i<6; i++)
		{
			if(!AsalMi(d[i])) kosul=false;
		}
		int toplam=0;
		for(int i=0; i<6; i++)
		{
			toplam=toplam+d[i];
		}
		System.out.println();
		
		if(toplam!=(61*6)) kosul=false;
		return kosul;
	}
	
	public boolean AsalMi(int d)
	{
		boolean res=true;
		for(int i=2; i<d; i++)
		{
			if(d%i==0||d==0) res=false;
		}
		return res;
	}
}
