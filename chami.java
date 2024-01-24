import java.util.*;
public class chami{
	
	private static String[] login = {"chamithd306", "19889"};
	private static int length = 0;
	private static String[][] supplier = new String[length][3];
	private static String[][] itemCategories = new String[0][0];
	private static String[][] items = new String[0][6];
	
	private final static void clearConsole(){
		final String os = System.getProperty("os.name");
		try {
			if (os.equals("Linux")) {
			System.out.print("\033\143");
			} else if (os.equals("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			}
		} catch (final Exception e) {
		//handle the exception
		System.err.println(e.getMessage());
		}
	}
	
	public static void rankItemsPerUnitPrice(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                RANKED UNIT PRICE                                      |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		
		String[][] temp = new String [items.length][6];
		
		for (int i = 0; i < items.length - 1; i++) {
			for (int j = 0; j < items.length - 1; j++) {
				if(Double.parseDouble(items[j][4]) > Double.parseDouble(items[j + 1][4])) {
					temp[j] = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp[j];
				}	
			}
		}
				System.out.println("+---------------------------------------------------------------+");
				System.out.printf("| %-7s | %-7s | %-14s | %-7s | %-5s | %-6s | %n", "SID", "CODE", "DESC", "PRICE", "QTY", "CAT");
				System.out.println("+---------------------------------------------------------------+");
				for (int k = 0; k < items.length; k++){
					System.out.printf("| %-7s | %-7s | %-14s | %-7s | %-5s | %-6s | %n",items[k][1] ,items[k][0] ,items[k][3] ,items[k][4] ,items[k][5] ,items[k][2] );
				}
				System.out.println("+---------------------------------------------------------------+");
		
		while(true){
				System.out.print("\nDo you want to go stock manage? (Y/N) ");
				String str = new Scanner(System.in).next();
					if (str.equals("y") | str.equals("Y")){	
						clearConsole();
						stockManage();
					}else if(str.equals("n") | str.equals("N")){
						clearConsole();
						rankItemsPerUnitPrice();
					}else{
						System.out.println("Ooops.........Wrong input!");
							continue ;
					}
				}
		}
	
	public static void viewItems(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                     VIEW ITEM                                         |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");

		if (itemCategories.length == 0){
			System.out.print("oops! seems that you don't have any item categories in the System. ");
				
				while(true){
					System.out.print("\nDo you want to add new item category? (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							addNewItemCategory();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							stockManage();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}
		}
			
			for (int i = 0; i < itemCategories.length; i++){
				System.out.print(itemCategories[i][0]+" :\n");
				
				System.out.println("+------------------------------------------------------+");
				System.out.printf("| %-7s | %-7s | %-14s | %-7s | %-5s | %n", "SID", "CODE", "DESC", "PRICE", "QTY");
				System.out.println("+------------------------------------------------------+");
				for (int k = 0; k < items.length; k++){
					if (itemCategories[i][0].equals(items[k][2])){
						System.out.printf("| %-7s | %-7s | %-14s | %-7s | %-5s | %n",items[k][1] ,items[k][0] ,items[k][3] ,items[k][4] ,items[k][5]);
					}
				}
				System.out.println("+------------------------------------------------------+");
				
			}
			while(true){
				System.out.print("\nDo you want to go stock manage? (Y/N) ");
				String str = new Scanner(System.in).next();
					if (str.equals("y") | str.equals("Y")){	
						clearConsole();
						stockManage();
					}else if(str.equals("n") | str.equals("N")){
						clearConsole();
						viewItems();
					}else{
						System.out.println("Ooops.........Wrong input!");
							continue ;
					}
			}
		}
		
	public static void getItemsSupplierWise(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                SEARCH SUPPLIER WISE                                   |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		
		if (items.length == 0){
			System.out.print("oops! seems that you don't have any item categories in the System. ");
				
				while(true){
					System.out.print("\nDo you want to add new item category? (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							addItem();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							stockManage();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}
		}
		
		String id;
		int index = 0;
		int count=0;
		while(true){
			System.out.print("Supplier id : ");
			id = new Scanner(System.in).next();
		
		for(int i=0;i<supplier.length;i++){
			
			if(id.equals(supplier[i][0])){
				index=i;
				}
			}	
			if((id.equals(supplier[index][0]))){
				System.out.println("Supplier name : "+supplier[index][1]);
				
			}else{
				System.out.println("\ncan't find supplier,try again !\n");
					while(true){
					System.out.print("\nDo you want to search another supplier? (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							getItemsSupplierWise();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							stockManage();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
					}
				}
				
		count = 0;
		for (int i = 0; i < items.length; i++){
			if (id.equals(items[i][1])){
				count = 1 ;
				break;
			}
		}
		if (count == 0){
			System.out.println("\nOops !.. No items in this supplier");
		}
				while(count == 1){
					System.out.println("+----------------------------------------------------------------------------------------+");
					System.out.printf("| %-12s | %-15s | %-14s | %-16s | %-17s |%n ","ITEM CODE","DESCRIPTION","UNIT PRICE","QTY ON HAND","CATEGORY");
					System.out.println("+----------------------------------------------------------------------------------------+");
					for (int k = 0; k < items.length; k++){
						if(id.equals(items[k][1])){
						System.out.printf("| %-12s | %-15s | %-14s | %-16s | %-17s |%n", items[k][0], items[k][3], items[k][4], items[k][5], items[k][2]);
					}
					}
					System.out.println("+----------------------------------------------------------------------------------------+");
					System.out.print("\nSearch Successfully..");
					break;
				}
				
				while(true){
					System.out.print("\nDo you want to search another supplier? (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							getItemsSupplierWise();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							stockManage();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}		
		}
		}
	
	public static void growItems(){
		String[][] newArr=new String[items.length+1][6];
		for(int i=0;i<items.length;i++){
			for(int j=0;j<items[i].length;j++){
				newArr[i][j]=items[i][j];
				}
			}
			items=newArr;
		}
	
	public static void addItem(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                      ADD ITEM                                         |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		
		while(true){
		if (itemCategories.length == 0){
			System.out.print("oops! seems that you don't have any item categories in the System. ");
				
				while(true){
					System.out.print("\nDo you want to add new item category? (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							addNewItemCategory();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							stockManage();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}
		}
		
		if (supplier.length == 0){
			System.out.print("oops! seems that you don't have any suppliers in the System. ");
				
				while(true){
					System.out.print("\nDo you want to add new supplier? (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							addSupplier();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							stockManage();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}
		}
			String itemCode;
			while(true){
				System.out.print("Item code: ");
				itemCode = new Scanner(System.in).next();
				int count=0;
				for(int i=0;i<items.length;i++){
				if(itemCode.equals(items[i][0])){
					count++;
					}
				}
				
					if(count==0){
						break;
						}else if(count==1){
						System.out.println("already difined,try another item code");
						continue;	
						}
			}
			growItems();
			items[items.length-1][0] = itemCode;
			
		System.out.println("+---------------------------------------------------------------------+");
		System.out.printf("| %-9s | %-26s | %-26s |%n" ,("#"), ("SUPPLIER ID"), ("SUPPLIER NAME"));
		System.out.println("+---------------------------------------------------------------------+");
		for (int i = 0, j = 1; i < supplier.length; i++){
				System.out.printf("| %-9s | %-26s | %-26s |%n" ,(j) ,supplier[i][0] ,supplier[i][1] );	
				supplier[i][2] = String.valueOf(j);
				j++;
		}
		System.out.println("+---------------------------------------------------------------------+");
		
		String supplierNum;
        int z = 0;
            do{
               z = 0;
               System.out.print("Enter the supplier number : ");
               supplierNum = new Scanner(System.in).next();
                  for (int i = 0; i < supplier.length; i++){
						if (supplierNum.equals(supplier[i][2])){
                              z = 1; 
                        }
                  }
                if (z == 0){
                   System.out.print("Wrong number! ");
                }
             
             }while(z == 0);                     
                   for (int i = 0; i < supplier.length; i++){
                       if (supplierNum.equals(supplier[i][2])){
                          items[items.length - 1][1] = supplier[i][0];
                       }
                   }
		//items[items.length-1][1] = supplier[supplierNum-1][0];
		
		//System.out.print(Arrays.toString(items[0]));
		
		System.out.println("\n+----------------------------------------+");
		System.out.printf("| %-9s | %-26s |%n" ,("#"), ("CATEGORY NAME"));
		System.out.println("+----------------------------------------+");
		for (int i = 0, j = 1; i < itemCategories.length; i++){
				System.out.printf("| %-9s | %-26s |%n" ,(j) ,itemCategories[i][0]);	
				itemCategories[i][1] = String.valueOf(j);
				j++;
		}
		System.out.println("+----------------------------------------+");
		
		String categoryNum;
        int y = 0;
             do{
                y = 0;
				System.out.print("Enter the Category number : ");
				categoryNum = new Scanner(System.in).next();
                     for (int i = 0; i < itemCategories.length; i++){
                              if (categoryNum.equals(itemCategories[i][1])){
                                       y = 1;
                              }
                     }
                          if (y == 0){
							System.out.print("Wrong number! ");

                           }
              }while(y == 0);
                     for (int i = 0; i < itemCategories.length; i++){
                          if (categoryNum.equals(itemCategories[i][1])){
                               items[items.length - 1][2] = itemCategories[i][0];
                          }
                     }
		
		//items[items.length-1][2] = itemCategories[categoryNum-1];
		
		//System.out.print(Arrays.toString(items[0]));
		
		System.out.print("\nDescription : ");
		String description = new Scanner(System.in).next();
		items[items.length-1][3] = description;
		
		System.out.print("Unit price : ");
		double unitPrice = new Scanner(System.in).nextDouble();
		items[items.length-1][4] = String.valueOf(unitPrice);
		
		System.out.print("QTY on Hand : ");
		int qty = new Scanner(System.in).nextInt();
		items[items.length-1][5] = String.valueOf(qty);
		
		System.out.print("Added successfully...");
		while (true){
			
			System.out.print("Do you want to add new item (Y/N)");
			String str = new Scanner(System.in).next();
					if (str.equals("y") | str.equals("Y")){	
						 clearConsole();
						 addItem();
					}else if(str.equals("n") | str.equals("N")){
						clearConsole();
						stockManage();
					}else{
						System.out.println("Ooops.........Wrong input!");
						continue ;
					}
			}
		}
	}
	
	public static void updateItemCategory(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                              UPDATE ITEM CATEGORIES                                   |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		
		if (itemCategories.length == 0){
			System.out.print("oops! seems that you don't have any item categories in the System. ");
				
				while(true){
					System.out.print("\nDo you want to add new item category? (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							addNewItemCategory();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							manageItemCategories();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}
		}
		
		L1:	while(true){
		
		System.out.print("Enter Item Category for update : ");
		String itemCategory = new Scanner(System.in).next();
		
		int index = 0;
		for (int i = 0; i < itemCategories.length; i++){
				if (itemCategories[i][0].equals(itemCategory)){
					index=i;
				}
			}
				
				if(itemCategories[index][0].equals(itemCategory)){
						
						System.out.print("Item Category : "+itemCategories[index][0]);
						System.out.println();
						System.out.println();
						System.out.print("\nEnter New Item Category Name : ");
						String name = new Scanner(System.in).next();
						
						itemCategories[index][0]= name;
						System.out.print("\nUpdated Successfully...");
						break;
				}else{
						System.out.println("Can't find item category . try agian...");
						continue;
						}	
					}
						
						
							while(true){
							System.out.print("\n\nDo you want to update another item category (Y/N) ");
							String str = new Scanner(System.in).next();
							
							if (str.equals("y") | str.equals("Y")){	
								clearConsole();
								updateItemCategory() ;
							}else if(str.equals("n") | str.equals("N")){
								clearConsole();
								manageItemCategories();
							}else{
								System.out.println("Ooops.........Wrong input!");
								continue ;
							}
						}			
					}

	public static void deleteItemCategory(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                              DELETE ITEM CATEGORIES                                   |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		
	if (itemCategories.length == 0){
			System.out.print("oops! seems that you don't have any item categories in the System. ");
				
				while(true){
					System.out.print("\nDo you want to add new item category? (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							addNewItemCategory();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							manageItemCategories();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}
		}

	String[][] temp = new String[itemCategories.length][2];
		int count;
		
		do{
		count=1;
		
		System.out.print("Enter item category : ");
		String item=new Scanner(System.in).next();
		
		for(int i=0;i<itemCategories.length;i++){
			if(item.equals(itemCategories[i][0])){
				count=0;
				temp=new String[itemCategories.length-1][2];
				
				for(int j=0,k=0;j<itemCategories.length;j++){
					if(item.equals(itemCategories[j][0])){
						
						continue;
						}
					temp[k++]=itemCategories[j];	
				}
				
				itemCategories=temp;
				
				System.out.print("delete successfully! Do you want to delete another?(Y/N) ");
				String choose=new Scanner(System.in).next();
				
				if(choose.equals("y")){
					clearConsole();
					deleteItemCategory();
				continue;
				}else if(choose.equals("n")){
					clearConsole();
					manageItemCategories();	
				}else{
					System.out.print("Wrong input,Do you want to delete another supplier?(Y/N)");
					choose=new Scanner(System.in).next();
				continue;	
				}	
			}
		}
		
		if(count==1){
			 System.out.println("can't find category name. try again! ");
			}
		}while(count==1);
		}

	public static void growItem(){
		String[][] Newarr=new String[itemCategories.length+1][2];
		for(int i=0;i<itemCategories.length;i++){
			for (int j = 0; j < itemCategories[i].length; j++){
				Newarr[i][j]=itemCategories[i][j];
			}
			  
			}
			itemCategories=Newarr;
		}

	public static void addNewItemCategory(){

		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                ADD ITEM CATEGORIES                                    |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");	
		int count=0;	
		int index=0;
		
	L1:	while (true) {
		count=0;	
			System.out.print("Enter the New Item Category : ");
			String itemCategory = new Scanner(System.in).next();
			
			for (int i = 0; i < itemCategories.length; i++){
				
				if (itemCategory.equals(itemCategories[i][0])){
					count++;	
			}
		}
			
			if (count!=0){
					System.out.println("alredy have item category...");
					System.out.println();
					continue L1;
				}else{
					growItem();
					itemCategories[itemCategories.length-1][0] = itemCategory;
					System.out.println("Added Successfully...");
					break;
				}
			
		}
			
			while (true){
				System.out.print("Do you want to add another category (Y/N) ");
				String str = new Scanner(System.in).next();
					if (str.equals("y") | str.equals("Y")){	
						 clearConsole();
						 addNewItemCategory();
					}else if(str.equals("n") | str.equals("N")){
						clearConsole();
						manageItemCategories();
					}else{
						System.out.println("Ooops.........Wrong input!");
						continue ;
					}
			}
		}
			
	public static void manageItemCategories(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                              MANAGE ITEM CATEGORIES                                   |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		System.out.println("[1] Add New Item Category\t\t\t [2] Delete Item Category");
		System.out.println("[3] Update Item Category \t\t\t [4] Stock Management");
		
		while(true){
		System.out.print("\n\nEnter an option to continue > ");
		String option = new Scanner(System.in).next();
		
			switch (option){
				case "1":
					clearConsole();
					addNewItemCategory();
					break;
				case "2":
					clearConsole();
					deleteItemCategory();
					break;
				case "3":
					clearConsole();
					updateItemCategory();
					break;
				case "4":
					clearConsole();
					stockManage();
					break;
				default:
					System.out.println("Invalid option....try agian");
					
			}
		}
	}
	
	public static void stockManage(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                    STOCK MANAGE                                       |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		System.out.println("[1] Manage Item Categories   \t\t\t[2] Add Item ");
		System.out.println("[3] Get Items Supplier Wise  \t\t\t[4] View Items ");
		System.out.println("[5] Rank Items Per Unit Price\t\t\t[6] HOME PAGE ");
		
		while(true){
		System.out.print("\n\nEnter an option to continue > ");
		String option = new Scanner(System.in).next();
		
			switch (option){
				case "1":
					clearConsole();
					manageItemCategories();
					break;
				case "2":
					clearConsole();
					addItem();
					break;
				case "3":
					clearConsole();
					getItemsSupplierWise();
					break;
				case "4":
					clearConsole();
					viewItems();
					break;
				case "5":
					clearConsole();
					rankItemsPerUnitPrice();
					break;
				case "6":
					clearConsole();
					homePage();
					break;
				default:
					System.out.println("Invalid option....try agian");
					
			}
		}
	}
	
	public static String[][] grow(){
		String[][] newArr=new String[supplier.length+1][3];
		for(int i=0;i<supplier.length;i++){
			for(int j=0;j<supplier[i].length;j++){
				newArr[i][j]=supplier[i][j];
				}
		}
		return newArr;
	}
	
	public static void searchSupplier(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                 SEARCH SUPPLIER                                       |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		
		if (supplier.length == 0){
			System.out.print("oops! seems that you don't have any Suppliers in the System. ");
				
				while(true){
					System.out.print("\nDo you want to add Supplier (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							addSupplier();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							homePage();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}
		}
		
		int index = 0;
		
		while(true){
		System.out.print("Supplier id : ");
		String id = new Scanner(System.in).next();
		
		for(int i=0;i<supplier.length;i++){
			
			if(id.equals(supplier[i][0])){
				index=i;
				}
			}
				
			if((id.equals(supplier[index][0]))){
				System.out.println("Supplier name : "+supplier[index][1]);
				System.out.print("\nfind successfully! ");
					break;
			}else{
				System.out.println("\ncan't find supplier,try again !\n");
					break;
				}
		
		}
			System.out.print("Do you want to find another supplier(Y/N)? ");
			String choose = new Scanner(System.in).next();
			
			while(true){
				if(choose.equals("y") || choose.equals("Y")){
					clearConsole();
					searchSupplier();
				}else if(choose.equals("n") || choose.equals("N")){
					clearConsole();
					supplierManage();
				}else{
					System.out.print("\nDo you want to find another supplier(Y/N)? ");
					choose = new Scanner(System.in).next();
						continue;
				}
		}	
		
	
	/*L1:	while(true){
		
		System.out.print("\nSupplier ID : ");
		String id = new Scanner(System.in).next();
	
		for (int i = 0; i < supplier.length; i++){
			
				if (supplier[i][0].equals(id)){
						
						System.out.print("Supplier Name : "+supplier[i][1]);
						System.out.println();
						System.out.print("\nSearch Successfully...");
					}
						if (!(supplier[i][0].equals(id))){
								System.out.println("Can't find supplier ID . try agian...");
								
								}
								
							while(true){
							System.out.print("\n\nDo you want to search another Supplier (Y/N) ");
							String str = new Scanner(System.in).next();
							
							if (str.equals("y") | str.equals("Y")){	
								 continue L1;
							}else if(str.equals("n") | str.equals("N")){
								clearConsole();
								supplierManage();
							}else{
								System.out.println("Ooops.........Wrong input!");
								continue ;
							}
						}		
					
			}
			//continue L1;
		}*/
		
	}	
		
	public static void viewSuppliers(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                 VIEW SUPPLIERS                                        |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		
		System.out.println();
		
		if (supplier.length == 0){
			System.out.print("oops! seems that you don't have any Suppliers in the System. ");
				
				while(true){
					System.out.print("\nDo you want to add Supplier (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							addSupplier();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							homePage();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}
		}
		
		System.out.println("+-----------------------------------------------------------+");
		System.out.printf("| %-27s | %-27s |%n" , ("SUPPLIER ID"), ("SUPPLIER NAME"));
		System.out.println("+-----------------------------------------------------------+");
		for (int i = 0; i < supplier.length; i++){
				System.out.printf("| %-27s | %-27s |%n" ,supplier[i][0] ,supplier[i][1] );	
		}
		System.out.println("+-----------------------------------------------------------+");	
		
					while(true){
							System.out.print("\n\nDo you want to go Supplier Manage Page (Y/N) ");
							String str = new Scanner(System.in).next();
							
							if (str.equals("y") || str.equals("Y")){	
								 clearConsole();
								 supplierManage();
							}else if(str.equals("n") || str.equals("N")){
								clearConsole();
								homePage();
							}else{
								System.out.println("Ooops.........Wrong input!");
								continue ;
							}
						}
		
	}
	
	public static void deleteSupplier(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                DELETE SUPPLIER                                        |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		
		if (supplier.length == 0){
			System.out.print("oops! seems that you don't have any Suppliers in the System. ");
				
				while(true){
					System.out.print("\nDo you want to add Supplier (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							addSupplier();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							homePage();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}
		}
	
		String[][] deleteArr=new String[supplier.length][3];
		
		int index = 0;
		String id = " ";
		int count;
			
		do{
		count = 1;
		
		System.out.print("Supplier Id : ");
		id = new Scanner(System.in).next();
		
		for(int i=0;i<supplier.length;i++){
			if(id.equals(supplier[i][0])){
				count = 0;
				deleteArr = new String[supplier.length-1][2];
				
				for(int j=0,k=0;j<supplier.length;j++){
					if(id.equals(supplier[j][0])){
						continue;
						}
					deleteArr[k++] = supplier[j];	
				}
				
				supplier = deleteArr;
				
				System.out.print("delete successfully! Do you want to delete another?(Y/N) ");
				String choose=new Scanner(System.in).next();
				
				if(choose.equals("y") || choose.equals("Y")){
					clearConsole();
					deleteSupplier();
					continue;
				}else if(choose.equals("n") || choose.equals("N")){
					clearConsole();
					supplierManage();	
				}else{
					System.out.print("Wrong input! ,Do you want to delete another supplier?(Y/N)");
					choose = new Scanner(System.in).next();
					continue;	
				}	
			}
		}
		
		if(count == 1){
			 System.out.println("can't find supplier id. try again! ");
			}
		}while(count==1);
	
	/*	
	L1:	while(true){
		
		System.out.print("\nSupplier ID : ");
		String id = new Scanner(System.in).next();
		
		String[][] newSupplier = new String[(supplier.length-1)][2];
		int index = 0;
		for (int k = 0; k < supplier.length; k++){
			if (supplier[k][0].equals(id)){
				index = k;
			}else{
				System.out.println("Can't find supplier ID . try agian...");
					continue L1;
				}
		}
		
		
		for (int i = 0; i < supplier.length; i++){
					for (int j = 0; i < supplier.length; ){
						if (supplier[index][0].equals(id)){
							continue ;
						}
						
						newSupplier[j][0] = supplier[i][0];
						newSupplier[j][1] = supplier[i][1];
						j++;	
						break;
					}
						
				}
							while(true){
							System.out.print("\n\nDo you want to delete another Supplier (Y/N) ");
							String str = new Scanner(System.in).next();
							
							if (str.equals("y") | str.equals("Y")){	
								// continue L1;
								 clearConsole();
								 deleteSupplier();
							}else if(str.equals("n") | str.equals("N")){
								clearConsole();
								supplierManage();
							}else{
								System.out.println("Ooops.........Wrong input!");
								continue ;
							}
						}				
		}
		*/
	}
	
	public static void updateSupplier(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                UPDATE SUPPLIER                                        |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		
		if (supplier.length == 0){
			System.out.print("oops! seems that you don't have any Suppliers in the System. ");
				
				while(true){
					System.out.print("\nDo you want to add Supplier (Y/N) ");
					String str = new Scanner(System.in).next();
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							addSupplier();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							homePage();
						}else{
							System.out.println("Ooops.........Wrong input!");
								continue ;
						}
				}
		}
		
		while(true){
		
		System.out.print("\nSupplier ID : ");
		String id = new Scanner(System.in).next();
		
		int index = 0;
		for (int i = 0; i < supplier.length; i++){
			
				if (supplier[i][0].equals(id)){
					index = i;
				}
			}
					if(supplier[index][0].equals(id)){	
						System.out.print("Supplier Name : "+supplier[index][1]);
						System.out.println();
						System.out.println();
						System.out.print("Enter New Supplier Name : ");
						String name = new Scanner(System.in).next();
						
						supplier[index][1] = name;
						System.out.print("\nUpdated Successfully...");
						break;
					}else{
						System.out.print("Can't find supplier Id . try agian...");
						continue;
					}
				}
						while(true){
							System.out.print("\n\nDo you want to go another Supplier (Y/N) ");
							String str = new Scanner(System.in).next();
							
							if (str.equals("y") | str.equals("Y")){	
								 clearConsole();
								 updateSupplier();
							}else if(str.equals("n") | str.equals("N")){
								clearConsole();
								supplierManage();
							}else{
								System.out.println("Ooops.........Wrong input!");
								continue ;
							}
						}		
		}	
		
	public static void addSupplier(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                 ADD SUPPLIER                                          |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		
	L2:	while(true){		
			int count=0;
			String id;
			do{
				count = 0;
				System.out.print("\nSupplier Id : ");
				 id = new Scanner(System.in).next();
					
			for(int i=0;i<supplier.length;i++){
				if(id.equals(supplier[i][0])){
					count++;
					}
				}
				if(count!=0){
				System.out.println("already exists . try another supplier id !");
				}
				
			}while(count!=0);
			
			System.out.print("Supplier name : ");
			String name = new Scanner(System.in).next();
			
			supplier = grow();
			
			supplier[supplier.length-1][0] = id;
			supplier[supplier.length-1][1] = name;
			
			System.out.print("\nAdded successfully! ");
		
		L1: while(true){
			System.out.print("Do you want to add another supplier(Y/N) :");
			String str = new Scanner(System.in).next();
			
			if (str.equals("y") | str.equals("Y")){	
								clearConsole();
								addSupplier();
							}else if(str.equals("n") | str.equals("N")){
								clearConsole();
								supplierManage();
							}else{
								System.out.println("Ooops.........Wrong input!");
								continue L1;
							}
					}		
		}
	}
	
	public static void supplierManage(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                               SUPPLIER MANAGE                                         |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		System.out.println("[1] Add Supplier   \t\t\t[2] Update Supplier ");
		System.out.println("[3] Delete Supplier\t\t\t[4] View Supplier ");
		System.out.println("[5] Search Supplier\t\t\t[6] HOME PAGE ");
		
		while(true){
		System.out.print("\n\nEnter an option to continue > ");
		String option = new Scanner(System.in).next();
		
			switch (option){
				case "1":
					clearConsole();
					addSupplier();
					break;
				case "2":
					clearConsole();
					updateSupplier();
					break;
				case "3":
					clearConsole();
					deleteSupplier();
					break;
				case "4":
					clearConsole();
					viewSuppliers();
					break;
				case "5":
					clearConsole();
					searchSupplier();
					break;
				case "6":
					clearConsole();
					homePage();
					break;
				default:
					System.out.println("Invalid option....try agian");
			}
		}
	}

	public static void logOut(){
		userLogin();
		}
	
	public static void exit(){
		System.exit(0);
		}
	
	public static void passwordChange(){
		while(true){
		System.out.print("Please enter the username to verify it's you : ");
		String verifyuser = new Scanner(System.in).next();
		if (verifyuser.equals(login[0])){
			System.out.println("Hey "+login[0]+"....");
			while (true){
				System.out.print("\nEnetr your currunt password : ");
				String curruntpwd = new Scanner(System.in).next();
				if (curruntpwd.equals(login[1])){
					System.out.print("\nEnter your New password : ");
					String newpwd = new Scanner(System.in).next();
					login[1] = newpwd;
					System.out.println("\n\nYour password change succesfully....");
					while(true){
						System.out.print("\nDo you want to go HOME PAGE (Y/N) ");
						String str = new Scanner(System.in).next();
						
						if (str.equals("y") | str.equals("Y")){	
							clearConsole();
							homePage();
						}else if(str.equals("n") | str.equals("N")){
							clearConsole();
							exit();
						}else{
							System.out.println("Ooops.........Wrong input!");
						}
						}
				}else{
					System.out.println("Incorrect password");
				}
			}
		}else{
			System.out.println("Invalid username....");
		}
		}
	}

	public static void homePage(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                       WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                         |");
		System.out.println("+---------------------------------------------------------------------------------------+\n");
		System.out.println("[1] Change the Credentials\t\t\t[2] Supplier Manage");
		System.out.println("[3] Stock Manage\t\t\t\t[4] Log out");
		System.out.println("[5] Exit the System");
		
		while(true){
		System.out.print("\n\nEnter an option to continue > ");
		String option = new Scanner(System.in).nextLine();
		
				switch (option){
					case "1":
						clearConsole();
						passwordChange();
						break;
					case "2":
						clearConsole();
						supplierManage();
						break;
					case "3":
						clearConsole();
						stockManage();
						break;
					case "4":
						clearConsole();
						logOut();
						break;
					case "5":
						exit();
						break;
					default:
						System.out.println("Invalid option....try agian");
				}
			}		
		}
	
	public static void userLogin(){
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                  LOGIN PAGE                                           |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		while (true){
			System.out.print("\nUser Name : ");
			String userName = new Scanner(System.in).next();
			if (userName.equals(login[0])){
				break;
			}else{
				System.out.println("user name is invalid... please try agian!");
				}
			}
				while (true){
					System.out.print("\nPassword : ");
					String password = new Scanner(System.in).next();
					if (password.equals(login[1])){
						clearConsole();
						homePage();
						break;
					}else{
						System.out.println("Incorrect password... please try agian!");
						}
				}	
		}
	
	public static void main(String args[]){
		userLogin();
		}
	}

