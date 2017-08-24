package br.com.fis.camel.res;

import com.ancientprogramming.fixedformat4j.format.FixedFormatManager;
import com.ancientprogramming.fixedformat4j.format.impl.FixedFormatManagerImpl;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			FixedFormatManager manager = new FixedFormatManagerImpl();
			
			String in = "Q2211442700OK                                                                              4092     =RC=                   20170821      12033714338896                                                                                    WEBSERVICE00051408614199980130VANDA PEREIRA SILVA       J112211030005140861419998005           N000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                                                                              ";
			
			OutBean out = manager.load(OutBean.class, in);
			
			String teste = manager.export( out );
			
			System.out.println( in );
			System.out.println( teste );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
