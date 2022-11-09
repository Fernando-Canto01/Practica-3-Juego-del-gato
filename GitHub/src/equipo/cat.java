package equipo;

import java.util.Scanner;

public class cat {
	
	 public static void main(String []args){
		 
		 class JuegoGame{
			 
			 char [][]gato;
			 
			 public JuegoGame(){
			  gato = new char[3][3];
			  //fila 1
			  gato[0][0] = ' '; gato[0][1] = ' '; gato[0][2] = ' ';
			  //fila 2
			  gato[1][0] = ' '; gato[1][1] = ' '; gato[1][2] = ' ';
			  //fila 3
			  gato[2][0] = ' '; gato[2][1] = ' '; gato[2][2] = ' ';
			 }
			 
			 public String mostrarTablero(){
			  String tab = "";
			  
			  for(int x = 0 ; x < gato.length ; x++){
			   tab += "\t";
			   for(int i = 0 ; i < gato.length ; i++){
			    tab += String.valueOf(gato[x][i]);
			    if( i < gato.length -1){
			     tab += " | ";
			    }
			   }
			   if(x < gato.length -1){
			    tab +="\n\t---------\n";
			   }
			  }
			  return tab;
			 }
			 
			 public boolean comprobarLugarLimpio(int[] cor){
			  if(gato[cor[0]-1][cor[1]-1] == 'X' || gato[cor[0]-1][cor[1]-1] == 'O'){
			   return true;
			  }else{
			   return false;
			  }
			 }
			 
			 public void setCoordenada(int [] cor, boolean alternar){
			  int x = cor[0],y = cor[1];
			  if(alternar){
			   gato[x-1][y-1] = 'X';
			  }else{
			   gato[x-1][y-1] = 'O';
			  }
			 }
			 
			 public int[] jugarIA(){
			  int cor[] = new int[2];
			  do{
			   cor[1] = (int)((Math.random()*3)+1);
			   cor[0] = (int)((Math.random()*3)+1);
			  }while(comprobarLugarLimpio(cor));
			  return cor;
			 }
			 
			 public boolean comprobarEmpate(){
			  boolean comp = false;
			  int cont = 0;
			  
			  for(int x = 0 ; x < gato.length ; x++){
			   for(int y = 0; y < gato.length ; y++){
			    if(gato[x][y] == 'X' || gato[x][y] == 'O'){
			     cont++;
			    }
			   }
			  }
			  
			  if(cont < 9){
			   comp = false;
			  }else{
			   comp = true;
			  }
			  return comp;
			 }
			 
			 public boolean comprobarWin(boolean alternar){
			  boolean win[] = new boolean[3];
			  win[0] = false;
			  win[1]=false;
			  win[2]= false;
			  boolean ganador = false;
			  boolean salir = false;
			  int ganadas = 0;
			  int contador = 0;
			  int x = 0;
			  int y = 0;
			  do{
			   if(alternar){
			    if('X' == gato[x][y]){
			     win[ganadas] = true;
			     ganadas++;
			     if(win[0] && win[1] && win[2]){
			      ganador = true;
			     }
			    }
			   }else{
			    if('O' == gato[x][y]){
			     win[ganadas] = true;
			     ganadas++;
			     if(win[0] && win[1] && win[2]){
			      ganador = true;
			     }
			    }
			   }
			   contador++;
			   if(contador <= 9){
			    y++;
			   }else if(contador > 9 && contador < 18){
			    x++;
			   }
			   
			   else if(contador > 18 && contador < 21){
			    y++;
			    x++;
			   }else if(contador >= 21){
			    if(contador == 22){
			     x--;
			     y++;
			    }else if(contador == 23){
			     x--;
			     y++;
			    }
			   }
			   if(contador == 0){
			    win[0] = false;
			    win[1]=false;
			    win[2]= false;
			    ganadas = 0;
			   }
			   if(contador == 3){
			    win[0] = false;
			    win[1] = false;
			    win[2] = false;
			    ganadas = 0;
			    x++;
			    y=0;
			   }else if(contador == 6){
			    win[0] = false;
			    win[1] = false;
			    win[2] = false;
			    ganadas = 0;
			    x++;
			    y=0;
			   }else if(contador == 9){
			    win[0] = false;
			    win[1] = false;
			    win[2] = false;
			    ganadas = 0;
			    x=0;
			    y=0;
			   }else if(contador == 12){
			    win[0] = false;
			    win[1] = false;
			    win[2] = false;
			    ganadas = 0;
			    x = 0;
			    y++;
			   }else if(contador == 15){
			    win[0] = false;
			    win[1] = false;
			    win[2] = false;
			    ganadas = 0;
			    x = 0;
			    y++;
			   }
			   if(contador == 18){
			    win[0] = false;
			    win[1] = false;
			    win[2] = false;
			    ganadas = 0;
			    x=0;
			    y=0;
			   }else if(contador == 21){
			    win[0] = false;
			    win[1] = false;
			    win[2] = false;
			    ganadas = 0;
			    x=2;
			    y=0;
			   }
			   else if(contador ==24){
			    salir = true;
			   }
			  }while(!salir);
			  
			  return ganador;
			 }
			}
		 
		 
		 
		  JuegoGame game = new JuegoGame();
		  Scanner entrada = new Scanner(System.in);
		  int coordenada[] = new int[2];
		  boolean alternar = true;
		  boolean salir = false;
		  boolean ia = false;
		  boolean coorVer = false;
		  
		  System.out.println("Bienvenido al juego del gato.\nEste juego fue creado por:\n+Fernando Canto\n+Lopez Acosta Claudino Brishel\n+Valencia Hernandez Carlos Eduardo");
		  do{
		   System.out.print("\n\nPuedes jugar contra otra persona o contra la computadora.\nContra quien quieres jugar?\n(1 = contra otra persona | 2 = contra la computadora): ");
		   if(entrada.nextInt() == 2){
		    ia = true;
		   }
		   
		   System.out.println("\nA JUGAR!");
		   
		   System.out.println("\nPrimero jugara el jugador X\n");
		  
		   do{
		    System.out.println("\n"+game.mostrarTablero()+"\n");
		    do{
		     coorVer = false;
		     if(alternar){
		      System.out.print("[*] Jugador X, Escoge fila: ");
		      coordenada[0] = entrada.nextInt();
		      System.out.print("[*] Jugador X, Escoge columna: ");
		      coordenada[1] = entrada.nextInt();
		     }else if(!ia && !alternar){
		      System.out.print("[*] Jugador O, Escoge fila: ");
		      coordenada[0] = entrada.nextInt();
		      System.out.print("[*] Jugador O, Escoge columna: ");
		      coordenada[1] = entrada.nextInt();
		     }else{
		      coordenada = game.jugarIA();
		      System.out.println("La computadora escogio:\nFila: "+coordenada[0]+"\nColumna: "+coordenada[1]);
		     }
		     if(coordenada[0] < 1 || coordenada[0] > 3 || coordenada[1] < 1 || coordenada[1] > 3){
		      coorVer = true;
		      System.out.println("\nSolo puedes introducir numeros del 1 al 3\n");
		     }else if(!coorVer){
		      if(game.comprobarLugarLimpio(coordenada)){
		       System.out.println("\nEse lugar se encuentra ocupado ya.\n");
		       coorVer = true;
		      }
		     }
		    }while(coorVer);
		    game.setCoordenada(coordenada, alternar);
		    if(game.comprobarWin(alternar) || game.comprobarEmpate()){
		     System.out.println("\n"+game.mostrarTablero());
		     if(game.comprobarEmpate()){
		      System.out.println("\n[->*] NO HAY GANADOR [*<-]");
		     }else if(alternar){
		      System.out.println("\n[->*] EL GANADOR ES EL JUGADOR X [*<-]");
		     }else if(!alternar){
		      System.out.println("\n[->*] EL GANADOR ES EL JUGADOR O [*<-]");
		     }
		     
		     System.out.println("\nVolver al menu?");
		     entrada.nextLine();
		     if(entrada.nextLine().equalsIgnoreCase("si")){
		      game = null;
		      game = new JuegoGame();
		      alternar = true;
		      salir = false;
		      break;
		     }else{
		      salir = true;
		      break;
		     }
		    }else{
		     if(alternar)
		      alternar = false;
		     else
		      alternar = true;
		    }
		    
		   }while(true);
		  }while(!salir);
		  entrada.close ();
	 }
	
	

}
