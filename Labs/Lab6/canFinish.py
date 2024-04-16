from collections import *

def canFinish(numCourses, prerequisites):
    inDegree = [0] * numCourses;
    adj_list = defaultdict(list)
    
    for course, prereq in prerequisites:
        adj_list[prereq].append(course)
        inDegree[course] += 1

    q = deque()

    #Load the 0 indegree into q
    for i in range(numCourses):
        if inDegree[i] == 0:
            q.append(i)
    
    final = []

    while q:
        curr = q.popleft()
        final.append(curr)
        for neighbor in adj_list[curr]:
            inDegree[neighbor] -= 1
            if inDegree[neighbor] == 0:
                q.append(neighbor)
    return len(final) == numCourses

    