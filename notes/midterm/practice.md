Containment and array of objects

containment - putting an object inside another.
public class a { }
public class b {
	a a1 = new a();
}
public class c {
	b b1 [];
	c() {
		b1 = new b[3]; //array of objects.
		b1[0] = new b(); //each b has a.
		b1[1] = new b();
		b1[2] = new b();
}
//main
c a1 = new c(); //how many objects - 8 (final answer)
