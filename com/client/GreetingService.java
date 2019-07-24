package com.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.shared.Reg;
import com.shared.farmerslist;
import com.shared.fdet;
import com.shared.nuti;
import com.shared.sevent;


/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
  String checkc(String s1,String s2) throws IllegalArgumentException;
  String checkf(String s1,String s2) throws IllegalArgumentException;
  String reg(Reg k) throws IllegalArgumentException;
  String freg(Reg m) throws IllegalArgumentException;
  String feed(String f)throws IllegalArgumentException;
  String land(nuti n)throws IllegalArgumentException;
  fdet det(fdet f,String i)throws IllegalArgumentException;
  String book(String r)throws IllegalArgumentException;
  String show(String s)throws IllegalArgumentException;
  String fevnt(sevent l)throws IllegalArgumentException;
  sevent evnt(sevent k)throws IllegalArgumentException;
  farmerslist allfar(String l)throws IllegalArgumentException;
  
 
}
