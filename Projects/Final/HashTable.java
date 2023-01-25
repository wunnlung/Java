public class HashTable{

	public int size;
	public User[] table;

	public HashTable(){
		size = 10000;
		table = new User[size];

	}

	public int index(User e){
		char[] username = e.username.toCharArray();
		int hashval;
		int a = 10000;
		int b = 26;
	    int x = 0;
	    int y = 1;
	    for (int i = 0; i < username.length; i++){
	        x = (int) ((x + (username[i] + username[username.length-1] - 1) * y) % a);
	      	y = (y * b) % a;
	    }
	    hashval = x;
	    //System.out.println(hashval);
	    return hashval;
	}

	public void insert(User e){
		int hashval = index(e);
		while(table[hashval] != null){
			hashval++;
			if(hashval == 10001){
				hashval=0;
			}
		}
		table[hashval]=e;
	}

	public void findpos(User e){
		int hashval = index(e);
		System.out.println(hashval);
	}

	public User finduser(String e){
		char[] username = e.toCharArray();
		int hashval;
		int a = 10000;
		int b = 26;
	    int x = 0;
	    int y = 1;
	    for (int i = 0; i < username.length; i++){
	        x = (int) ((x + (username[i] + username[username.length-1] - 1) * y) % a);
	      	y = (y * b) % a;
	    }
	    hashval = x;
	    return table[hashval];
	}

	public void display(){
		int i;
		for(i=0;i<size;i++){
			if(table[i] == null){
				//System.out.println(i + " null");
			}else{
				System.out.println(i + " " + table[i].toString());
			}
		}
	}

	public User[] toWrite(){
		User[] fin = new User[1000];
		int index = 0;
		int i;
		for(i=0;i<size;i++){
			if(table[i]!=null){
				fin[index] = table[i];
				index++;
			}
		}
		return fin;
	}

	/*public static void main(String[] args) {
		HashTable a = new HashTable();
		User g = new User("gcortgrwef","gcortgras","hi");
		User t = new User("tuiywruiy","a","f");
		a.insert(g);
		a.insert(t);
		a.display();
		a.findpos(g);
		System.out.println(a.finduser("gcortgras"));
	}*/
}