package wua.demo;

import wua.demo.menu.IkaSushi;
import wua.demo.menu.MenuItem;
import wua.demo.menu.TunaSushi;
import wua.demo.order.Order;
import wua.demo.table.Table;

/**
 * Simulate a Sushi Go Round system
 *
 * Goal:
 * - Put this on Dataflow and use sushi-go-round lingo to explain Dataflow concepts
 *
 * TODO:
 * - Put this on a Dataflow pipeline
 *   - Input: Stream random orders to Pub/Sub
 *   - Transform:
 *          - Grab items from order, stream each item to Pub/Sub.  One topic per menu type (e.g. drink, dessert, sushi, soup)
 *          - Each kitchen grabs its own items and prepare them
 *   - Output: Each kitchen delivers its prepared items to target table
 *
 *   Issue:
 *      How to limit parallelism to simulate kitchen bottlenecks?
 *          - Limit number of workers, and number of threads per worker.
 *          - Limit One item maximum per kitchen at any time.
 */
public class App 
{
    public static void main( String[] args )
    {

        Table t = Table.getAnyOpenTable();
        System.out.println(String.format("Table %s is open", t.getId()));
        t.occupy();
        t.occupy();

        Table.list(Table.Status.OPEN)
                .stream()
                .map(table -> table.getId())
                .forEach(System.out::println);

        MenuItem sushi = new IkaSushi();
        TunaSushi tuna = new TunaSushi();
        System.out.println(String.format("Price of %s is %d yen", sushi.getName(), sushi.getPrice() ));
        System.out.println(String.format("Price of %s is %d yen", tuna.getName(),tuna.getPrice() ));

        Table tableX = Table.occupyAnyTable();
        tableX.order(new IkaSushi());
        tableX.order(new IkaSushi());
        tableX.order(new TunaSushi());

        Order orderY = tableX.getOrder();


        int total = orderY.getItems()
                .stream()
                .mapToInt(x -> x.getPrice())
                .sum();
        System.out.println(total);
    }
}
