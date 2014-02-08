#include <string>

#include "Knapsack.hpp"
#include "CacheRegular.hpp"

int main(int argc, char** argv) {
  int n = 5;
  int bagSize = 10;
  int minSize = 1, maxSize = 5;
  int minValue = 10, maxValue = 100;

  if(argc > 1) n = std::stoi(argv[1]);
  if(argc > 2) bagSize = std::stoi(argv[2]);

  Cache* cachingCache = new CacheRegular(n, bagSize);
  Cache* dynamicCache = new CacheRegular(n, bagSize);

  Knapsack knapsack(n);
  knapsack.initSizes(minSize,maxSize);
  knapsack.initValues(minValue,maxValue);
  knapsack.print();

  int recursiveValue = knapsack.fillBagRecursive(n, bagSize);

  knapsack.setCache(cachingCache);
  int cachingValue = knapsack.fillBagCaching(n, bagSize);

  knapsack.setCache(dynamicCache);
  int dynamicValue = knapsack.fillBagDynamic(n, bagSize);

  std::cout << "Recursive Answer: " << recursiveValue << std::endl;
  std::cout << "Caching Answer: " << recursiveValue << std::endl;
  std::cout << "Dynamic Answer: " << dynamicValue << std::endl;

  std::cout << std::endl;
  
  std::cout << "Caching Cache:" << std::endl;
  cachingCache->print();
  std::cout << "Dynamic Cache:" << std::endl;
  dynamicCache->print();
}