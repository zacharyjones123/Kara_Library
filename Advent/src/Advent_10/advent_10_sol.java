package Advent_10;

import java.util.*;
import java.util.stream.*;
import java.nio.file.*;

import static java.lang.System.out;

public class advent_10_sol
{
    public static void main(String[] args) throws Exception
    {
        List<Integer> sparseHash = IntStream.range(0, 256).boxed().collect(Collectors.toList());

        byte[] bytes = Files.readAllBytes(Paths.get(args[0]));
        List<Integer> lengths = IntStream.concat(IntStream.range(0, bytes.length).map(i -> bytes[i]), 
                Arrays.asList(17, 31, 73, 47, 23).stream().mapToInt(Integer::intValue)).boxed().collect(Collectors.toList());

        int current = 0, skip = 0;
        for (int round = 0; round < 64; round++)
        {
            for (int length : lengths)
            {
                List<Integer> segment = new ArrayList<>();
                for (int i = current; i < current + length; i++)
                    segment.add(sparseHash.get(i % sparseHash.size()));
                Collections.reverse(segment);
                for (int i = 0; i < segment.size(); i++)
                    sparseHash.set((i + current) % sparseHash.size(), segment.get(i));
                current += length + skip++;
            }
        }

        final int size = sparseHash.size();
        List<String> denseHash = IntStream.range(0, (size + 15) >> 4)
                .mapToObj(i -> sparseHash.subList(i << 4, Math.min((i + 1) << 4, size)).stream().reduce((a, b) -> a ^ b).orElse(0))
                .map(i -> String.format("%02X", i).toLowerCase()).collect(Collectors.toList());

        for (String l : denseHash)
            out.print(new String(l, "UTF-8"));
        out.println();
    }
}