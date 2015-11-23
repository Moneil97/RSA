import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

public class RSA {

	public static void main(String[] args) {
		
		
		//say(toNumArray(456));
		
		long p1 = 104723;
		long p2 = 104729;
		//BigInteger n = new BigInteger("4");
		long n = p1 * p2;
		long phiN = phi(p1) * phi(p2);
		long e = 3;
		//say((2*phiN+1)%e);
		long d = (2*phiN+1)/e;
		
		say("d:" + d);
		
		
		say("hi");
		long message = sendMessage(n, e, "hi");
		say("message: " + message);
		
		say("decoded: " + decode(message, d, n));
		
		
		
//		int leftPublicKey;
//		int leftPrivateKey;
		//int rightPublicKey;
		//int rightPrivateKey;
		
		
		
	}
	
	private static long stringToVal(String s){
		
		String a = "";
		//Only works for a-j 
		//hi == 78
		for (char c : s.toCharArray())
			a += c-'a';
		
		return Long.parseLong(a);
		
	}
	
	private static String decode(long m, long d, long n){
		
		String s = "";
		BigInteger bm = new BigInteger(String.valueOf(m));
		BigInteger bd = new BigInteger(String.valueOf(d));
		BigInteger bn = new BigInteger(String.valueOf(n));
		
		BigInteger ba = bm.modPow(bd, bn);
		say("ba: " + ba);
		
		while (ba.longValue() > 0){
			s+= (char)ba.mod(big(10)).add(big(97)).intValue();
			ba = ba.divide(big(10));
		}
		
		return new StringBuilder(s).reverse().toString();
	}
	
	private static BigInteger big(long val){
		return new BigInteger(String.valueOf(val));
	}
	
	private static long sendMessage(long n, long e, String s){
		long m = stringToVal(s);
		return ((long)Math.pow(m, e)) % n;
	}
	
	private static void say(Object s){
		System.out.println(s);
	}
	
	private static long phi(long n){
		//if (isPrime(n))
			return n-1;
	}

}
