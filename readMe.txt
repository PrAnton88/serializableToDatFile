	
	any data
	
	������� 1
	����� TestGenericsInterface<T>
	� 
	public void testHi(MethodPerson obj){
		obj.Hi();
	}
	
	������
	TestGenericsInterface<MethodPerson> a = new TestGenericsInterface<MethodPerson>();
	
	�������� 
	a.testHi(new Person('������ ���'));
	



	������� 2
	����� TestGenericsInterface<T extends MethodPerson>
	� 
	public void testHi(T obj){
		obj.Hi();
	}

	������ 
	TestGenericsInterface<Person> a = new TestGenericsInterface<Person>();

	�������� 
	a.testHi(new Person("������ ���"));