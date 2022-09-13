<p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>largest element in the array</em>.</p>

<p>Note that it is the <code>k<sup>th</sup></code> largest element in the sorted order, not the <code>k<sup>th</sup></code> distinct element.</p>

<p>You must solve it in <code>O(n)</code> time complexity.</p>

<p>&nbsp;</p> 
<p><strong>Example 1:</strong></p> 
<pre><strong>Input:</strong> nums = [3,2,1,5,6,4], k = 2
<strong>Output:</strong> 5
</pre>
<p><strong>Example 2:</strong></p> 
<pre><strong>Input:</strong> nums = [3,2,3,1,2,4,5,5,6], k = 4
<strong>Output:</strong> 4
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Divide and Conquer | Sorting | Heap (Priority Queue) | Quickselect</details><br>

<div>👍 11802, 👎 597</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V1.9，[第 11 期刷题打卡挑战（9/19 开始）](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 开始报名。**



<p><strong><a href="https://labuladong.github.io/article?qno=215" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

二叉堆的解法比较简单，实际写算法题的时候，推荐大家写这种解法。

可以把小顶堆 `pq` 理解成一个筛子，较大的元素会沉淀下去，较小的元素会浮上来；当堆大小超过 `k` 的时候，我们就删掉堆顶的元素，因为这些元素比较小，而我们想要的是前 `k` 个最大元素嘛。

当 `nums` 中的所有元素都过了一遍之后，筛子里面留下的就是最大的 `k` 个元素，而堆顶元素是堆中最小的元素，也就是「第 `k` 个最大的元素」。

二叉堆插入和删除的时间复杂度和堆中的元素个数有关，在这里我们堆的大小不会超过 `k`，所以插入和删除元素的复杂度是 `O(logK)`，再套一层 for 循环，总的时间复杂度就是 `O(NlogK)`。

当然，这道题可以有效率更高的解法叫「快速选择算法」，只需要 `O(N)` 的时间复杂度。

快速选择算法不用借助二叉堆结构，而是稍微改造了快速排序的算法思路，有兴趣的读者可以看详细题解。

**详细题解：[快速排序详解及应用](https://labuladong.github.io/article/fname.html?fname=快速排序)**

**标签：二叉堆，快速选择算法，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆，堆顶是最小元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e : nums) {
            // 每个元素都要过一遍二叉堆
            pq.offer(e);
            // 堆中元素多于 k 个时，删除堆顶元素
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // pq 中剩下的是 nums 中 k 个最大元素，
        // 堆顶是最小的那个，即第 k 个最大元素
        return pq.peek();
    }
}
```

**类似题目**：
  - [703. 数据流中的第 K 大元素 🟢](/problems/kth-largest-element-in-a-stream)
  - [912. 排序数组 🟠](/problems/sort-an-array)
  - [剑指 Offer II 059. 数据流的第 K 大数值 🟢](/problems/jBjn9C)
  - [剑指 Offer II 076. 数组中的第 k 大的数字 🟠](/problems/xx4gT2)

</details>
</div>



