package lw03.unguided;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
		Map<String, Integer> enrollments = new LinkedHashMap<>();
		int rejectedOperations = 0;

		System.out.println("===== Enrollment Checks =====");
		while (sc.hasNext()) {
			String type = sc.next();
			String course = sc.next();

			if (type.equals("CHECK")) {
				if (enrollments.containsKey(course)) {
					System.out.println(course + ": " + enrollments.get(course) + " students");
				} else {
					System.out.println(course + ": Not found");
				}
			} else {
				int count = sc.nextInt();
				if (count <= 0) {
					rejectedOperations++;
				} else if (type.equals("REGISTER")) {
					int currentEnrollment = 0;
					if (enrollments.containsKey(course)) {
						currentEnrollment = enrollments.get(course);
					}
					enrollments.put(course, currentEnrollment + count);
				} else if (type.equals("WITHDRAW")) {
					if (!enrollments.containsKey(course) || enrollments.get(course) < count) {
						rejectedOperations++;
					} else {
						enrollments.put(course, enrollments.get(course) - count);
					}
				}
			}
		}
		sc.close();

		System.out.println();
		System.out.println("===== Final Enrollment =====");
		for (String course : enrollments.keySet()) {
			System.out.println(course + ": " + enrollments.get(course) + " students");
		}
        System.out.println();
		System.out.println("Rejected operations: " + rejectedOperations);
	}
}
