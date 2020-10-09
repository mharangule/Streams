import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stream.of("mahesh","suresh","harangule","karan","narendra","oza").filter(s->s.endsWith("sh"))
		//.map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		List<String> names=Arrays.asList("mahesh","suresh","harangule","karan","oza","narendra");
		names.stream().filter(s->s.endsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		ArrayList<String> names1=new ArrayList<String>();
		names1.add("don");
		names1.add("ankush");
		names1.add("atul");
		names1.add("bhima");
		names1.add("rushi");
		
		Stream<String>newstream=Stream.concat(names.stream(), names1.stream());
		newstream.sorted().forEach(s->System.out.println(s));
		
		//print unique no in the array
		//sort the array and print the 3rd index
		List<Integer> values=Arrays.asList(2,5,4,2,5,8,3,6,2,4,8,4,5);
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("the 3rd element is "+li.get(2));
		
	}

}
