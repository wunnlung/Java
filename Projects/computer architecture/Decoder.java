public class Decoder{

	//stores the address so we can grab it whenever we need it
	public int address = 0x9a040;
	public MIPS mip = new MIPS();

	//returns what format the hex is in
	//true for r-format, false for i-format (just for easy use)
	public boolean format(int input){
		int opc = mip.opcode(input);
		if(opc==0){
			return true;
		}
		return false;
	}

	//function to get the full decoded MIPS function
	public String decode(int input){
		boolean fm = format(input);

		//setting up the final instruction:
		String instruction;

		//if the MIPS is r-type:
		if(fm){

 			//getting the function
 			int f = mip.func(input);
 			String function;
 			//checking what it is
 			if(f==32){ //0x20
 				function = "ADD";
 			} else if(f==34){ //0x22
 				function = "SUB";
 			} else if(f==36){ //0x24
 				function = "AND";
 			} else if(f==37){ //0x25
 				function = "OR";
 			} else if(f==42){ //0x2A
 				function = "SLT";
 			} else{function = "NULL";} //just for errors and such

 			//getting the destination
 			int d = mip.dest(input);
 			String destination = " $" + Integer.toString(d);

 			//getting the first register
 			int r = mip.src1(input);
 			String register1 = " $" + Integer.toString(r);

 			//getting the second register
 			int r2 = mip.src2(input);
 			String register2 = " $" + Integer.toString(r2);

 			//creating the string for the address and instruction
 			instruction = Integer.toHexString(address) + ": " + function + destination + register1 + register2;
 			System.out.println(instruction);
 			//increase the address before we end the function
 			address += 4;
 			return instruction;
		}


		//if the MIPS is i-type
		else if(!fm){
			int op = mip.opcode(input);
			//do the same thing as above but with i-format functions
			String function;
			if(op==4){ // 0x04
				function = "BEQ";
			} else if(op==5){ //0x05
				function = "BNE";
			} else if(op==35){ //0x23
				function = "LW";
			} else if(op==43){ //0x2b
				function = "SW";
			} else{function = "NULL";} //for errors

			//for the branches
			if(function.equals("BNE") || function.equals("BEQ")){
				//first register (technically second)
				int r = mip.src2(input);
 				String register1 = " $" + Integer.toString(r);

 				//second register (technically first)
 				int r2 = mip.src1(input);
 				String register2 = " $" + Integer.toString(r2);

 				//sign extended offset:
 				//PC + SEO + 4
 				int of = address + 4 + mip.seo(input);
 				String offset = Integer.toHexString(of);

				instruction = Integer.toHexString(address) + ": " + function + register1 + register2 + " " + offset;
				System.out.println(instruction);
				address += 4;
 				return instruction;
			}
			//otherwise just continue normally
			else{
				//first register (technically second)
				int r = mip.src2(input);
 				String register1 = " $" + Integer.toString(r);

 				//offset (AS A SHORT)
 				Short o = mip.offset(input);
 				String offset = " " + Short.toString(o);

 				//second register (technically first)
 				int r2 = mip.src1(input);
 				String register2 = "($" + Integer.toString(r2) + ")";

 				//putting it all together
 				instruction = Integer.toHexString(address) + ": " + function + register1 + offset + register2;
 				System.out.println(instruction);
 				//increase the address before we end the function
 				address += 4;
 				return instruction;
			}
		}

		return "h";

	}

}

class runner{
	public static void main(String[] args) {
		/*
		//test code
		Decoder test = new Decoder();
		int test1 = 0x00a63820;
		int test2 = 0xad2dfffc;
		//System.out.println(test.format(test1));
		String t1 = test.decode(test2);
		//System.out.println(t1);
		*/

		
		//actual runner
		Decoder run = new Decoder();
		int i1 = 0x032BA020; //ADD $20 $25 $11
		int i2 = 0x8CE90014; //LW $9 0x14($7)
		int i3 = 0x12A90003; //BEQ $21 $9 0x3
		int i4 = 0x022DA822; //SUB $21 $17 $13
		int i5 = 0xADB30020; //SW $19 0x20($13)
		int i6 = 0x02697824; //AND $15 $19 $9
		int i7 = 0xAE8FFFF4; //SW $15 0xFFF4($20)
		int i8 = 0x018C6020; //ADD $12 $12 $12
		int i9 = 0x02A4A825; //OR $21 $21 $4
		int i10 = 0x158FFFF7; //BNE $12 $15 0xFFF7
		int i11 = 0x8ECDFFF0; //LW $13 0xFFF0($22)

		run.decode(i1);
		run.decode(i2);
		run.decode(i3);
		run.decode(i4);
		run.decode(i5);
		run.decode(i6);
		run.decode(i7);
		run.decode(i8);
		run.decode(i9);
		run.decode(i10);
		run.decode(i11);
		

	}
}