import java.io.File;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;

import java.util.concurrent.Callable;

import java.util.concurrent.ConcurrentHashMap;

import java.util.concurrent.ExecutionException;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.Future;

import java.util.concurrent.atomic.AtomicInteger;

// Implement a class

public class Token implements Callable<Map<String, String>> {

	// create a map

	final Map<String, String> InformToken;

	// declare string variable

	private final String[] FileLocation;

	AtomicInteger counter = new AtomicInteger(0);

	public Token(String[] Stringlocation)

	{

		// assign the string

		this.FileLocation = Stringlocation;

		this.InformToken = new ConcurrentHashMap<String, String>();

	}

	public Map<String, String> GetLocation(String FPath)

	{

		try {

			// create a list

			List<String> Ls = Files.readAllLines(Paths.get(FPath));

			int num = 1;

			// use loop

			for (String Line : Ls) {

				// assign method to split

				String[] strg = Line.split(" ");

				for (String string : strg) {

					String find = InformToken.putIfAbsent(string, FPath + ":" + num);

					if (find == null) {

					}

					else {

						// assigning

						String Location = find;

						Location += " " + FPath + ":" + num;

						InformToken.replace(string, Location);

					}

				}

				num++;

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

		return InformToken;

	}

	@Override

	// implement a method

	public Map<String, String> call() throws Exception

	{

		// assign and increment

		int ct = counter.getAndIncrement();

		return GetLocation(FileLocation[ct]);

	}

	// main function

	public static void main(String[] args)

	{

		// declare the variable

		int num_Threads = args.length;

		if (num_Threads == 0)

		{

			System.out.println("Sorry no File is found...Please input");

			return;

		}

		for (int i = 0; i < args.length; i++) {

			// read a file

			File Fi = new File(args[i]);

			if (!Fi.exists()) {

				System.out.println(args[i] + " Not Exist.");

				return;

			}

			// checks

			if (!(Fi.isFile() && Fi.canRead())) {

				// display

				System.out.println(Fi.getName() + " It Cannot be Read from.");

				return;

			}

		}

		ExecutorService Exe = Executors.newFixedThreadPool(num_Threads);

		// creating list string

		List<Future<Map<String, String>>> Lst = new ArrayList<Future<Map<String, String>>>();

		Callable<Map<String, String>> call = new Token(args);

		for (int i = 0; i < num_Threads; i++) {

			Future<Map<String, String>> Ft = Exe.submit(call);

			Lst.add(Ft);

		}

		Map<String, String> tks = new ConcurrentHashMap<String, String>();

		for (Future<Map<String, String>> fut : Lst) {

			try {

				tks = fut.get();

			} catch (InterruptedException | ExecutionException e) {

				e.printStackTrace();

			}

		}

		Exe.shutdown();

		// using loop to get map

		for (Map.Entry<String, String> token : tks.entrySet()) {

			System.out.println("Token Name-" + token.getKey() + " Path-" + token.getValue());

		}

	}

}