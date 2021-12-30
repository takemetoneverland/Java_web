package collection.list;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<>();
		
		//추가
		list.add("홍길동");
		list.add("김철수");
		list.add("박영희");
		
		list.addFirst("맨 앞");
		list.addLast("맨 뒤");
		System.out.println(list);

		System.out.println(list.get(3));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		
		list.remove(0);
		System.out.println(list);
		
		//LIFO -> last in first out -> stack ex)웹 뒤로가기 같은 것.
		//push(데이터 넣을 때), pop(데이터 꺼낼 때 삭제되며 나옴), peek(데이터 꺼낼 때)
		list.push("김뽀삐");
		System.out.println(list); //앞에서부터 추가
		
		System.out.println(list.pop()); //삭제하면서 읽기
		System.out.println(list);
		
		System.out.println(list.peek()); //삭제하지 않으면서 읽기
		System.out.println(list);
		
		//FIFO -> first in first out(선입선출 같은 것) -> Queue
		//offer, poll, peek
		list.offer("a"); //마지막에 추가
		list.offer("b"); //마지막에 추가
		list.offer("c"); //마지막에 추가
		
		System.out.println(list);
		
		System.out.println(list.poll());
		System.out.println(list);
		
		System.out.println(list.peek()); //삭제하지 않고 읽기
		System.out.println(list);
	
	}

}










