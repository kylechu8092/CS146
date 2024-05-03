def minMeetingRooms(intervals):   
    startList = sorted(interval[0] for interval in intervals)
    endList = sorted(interval[1] for interval in intervals)

    start,end,curr,maxRoom = 0,0,0,0
    while start < len(startList):
        if startList[start] < endList[end]:
            curr +=1
            start +=1
            maxRoom = max(curr, maxRoom)
        else:
            end +=1
            curr-=1
    return maxRoom


interval = [[0, 30], [5, 10], [15, 20]]
print(minMeetingRooms(interval))  # Output: 2


