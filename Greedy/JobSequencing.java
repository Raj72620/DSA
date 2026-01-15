package Greedy;
import java.util.*;

public class JobSequencing {

    int deadline;
    int id ;
    int profit;

     JobSequencing(int i,int d,int p) {
        this.id=i;
        this.deadline=d;
        this.profit=p;
    }
    public static void main(String[] args) {
        int[][] jobsInfo={{4,20},{1,10},{1,40},{1,30}};
        ArrayList<JobSequencing> jobs = new ArrayList<>();
        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new JobSequencing(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);

        int maxDeadline=0;
        for(JobSequencing job : jobs){
            if(job.deadline > maxDeadline){
                maxDeadline=job.deadline;
            }
        }
        boolean[] slots =new boolean[maxDeadline+1];
        ArrayList<Integer> seq=new ArrayList<>();
        int totalProfit=0;
        int jobCount=0;
        for(int i=0;i<jobs.size();i++){
            JobSequencing curr=jobs.get(i);

            for(int slot=curr.deadline ; slot>=1; slot--){
                if(!slots[slot]){
                    slots[slot]=true;
                    seq.add(curr.id);
                    totalProfit+=curr.profit;
                    jobCount++;
                    break;
                }
            }
        }
        System.out.println("Max Jobs :" + jobCount);
        System.out.println("Total Profit :" + totalProfit);

        System.out.println("Job Sequence :");
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+ " ");
        }
    System.out.println();
}
}
