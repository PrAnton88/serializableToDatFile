	
	any data
	
	вариант 1
	когда TestGenericsInterface<T>
	и 
	public void testHi(MethodPerson obj){
		obj.Hi();
	}
	
	создаём
	TestGenericsInterface<MethodPerson> a = new TestGenericsInterface<MethodPerson>();
	
	вызываем 
	a.testHi(new Person('Доктор Идо'));
	



	вариант 2
	когда TestGenericsInterface<T extends MethodPerson>
	и 
	public void testHi(T obj){
		obj.Hi();
	}

	создаём 
	TestGenericsInterface<Person> a = new TestGenericsInterface<Person>();

	вызываем 
	a.testHi(new Person("Доктор Идо"));