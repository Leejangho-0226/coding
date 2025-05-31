	package pack4extends;
	
	public class Ex20Manger extends Ex20Regular{
		private double incentive;
		
		 public Ex20Manger(String irum, int nai, int salary) {
			super(irum,nai,salary);
		}
		
		@Override
		public double pay() {
			double imsi = super.pay();
			
			if(imsi >= 2500000)
				incentive = imsi * 0.6;
			else if(imsi >= 2000000)
				incentive = imsi * 0.5;
			else
				incentive = imsi * 0.4;
			
			return incentive + imsi;
		}
		
		@Override
		public void print() {
			display();
			System.out.println(", 수령액:" + pay());
		}
	}

		
		
		
			
		
		
		
		
		
		
		
		
		
		
	
	 
	