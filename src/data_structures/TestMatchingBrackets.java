package data_structures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {

		Stack<Character> holder = new Stack<Character>(); 
		for(int i = 0; i < b.length();i++) {
			System.out.println(b.charAt(i));
			if (b.charAt(i) == '{') {
				holder.push('{');
			}
			if (b.charAt(i) == '}' && holder.isEmpty() == false) {
				holder.pop();
			}
		}

		if (holder.isEmpty()) {
		return true;
		} else {
		return false;	
		}
		
	}

}