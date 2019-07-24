package com.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.shared.Reg;
import com.shared.farmerslist;
import com.shared.fdet;
import com.shared.nuti;
import com.shared.sevent;


/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
  void checkc(String s1,String s2, AsyncCallback<String> callback)
      throws IllegalArgumentException;
  void checkf(String s1,String s2, AsyncCallback<String> callback)
	      throws IllegalArgumentException;
  void reg(Reg k, AsyncCallback<String> callback)
	      throws IllegalArgumentException;
  void freg(Reg m, AsyncCallback<String> callback)
	      throws IllegalArgumentException;
  void feed(String f, AsyncCallback<String> callback)
	      throws IllegalArgumentException;
  void land(nuti n, AsyncCallback<String> callback)
	      throws IllegalArgumentException;
  void det(fdet f,String i, AsyncCallback<fdet> callback)
	      throws IllegalArgumentException;
  void book(String r, AsyncCallback<String> callback)
	      throws IllegalArgumentException;
  void show(String s, AsyncCallback<String> callback)
	      throws IllegalArgumentException;
  void fevnt(sevent l, AsyncCallback<String> callback)
	      throws IllegalArgumentException;
  void evnt(sevent k, AsyncCallback<sevent> callback)
	      throws IllegalArgumentException;
  void allfar(String l, AsyncCallback<farmerslist> callback)
	      throws IllegalArgumentException;

  
}