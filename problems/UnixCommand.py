# Hello World program in Python
    
def simplify(B,A):

    dir = ""
    st= []
    res = ""
    res += "/"
    len_A = len(A)
    i = 0
    len_B = len(B)
    while i < len_B:
       dir_str = ""
       while(i < len_B and B[i]=='/'):
        i += 1
       while (i < len_B and B[i] != '/'):
         dir_str += B[i]
         i += 1

       if len(dir_str) > 0:
             st.append(dir_str)

       i+=1


    i=0
    if(A[0]=='/'):
        st=[]
    while i < len_A:
      dir_str = ""
      while (i < len_A and A[i] == '/'):
         i += 1
      while (i < len_A and A[i] != '/'):
         dir_str += A[i]
         i += 1
      if dir_str == "..":
         if len(st):
            st.pop()
      elif dir_str == '.' or dir_str== ' ':
             continue
      elif dir_str.isalnum()!= True:
          return A+" :no such directory"
      elif len(dir_str) > 0:
             st.append(dir_str)
        
      i += 1

    st1 = []
    while len(st):
      st1.append(st[-1])
      st.pop()

    while len(st1):
      temp = st1[-1]
      if (len(st1) != 1):
         res += (temp + "/")
      else:
         res += temp
      st1.pop()

    return res


print(simplify("/","abc")+'\n')
print(simplify("/abc/def","ghi")+'\n')
print(simplify("/abc/def","..")+'\n')
print(simplify("/abc/def","/abc")+'\n')
print(simplify("/abc/def","/abc/klm")+'\n')
print(simplify("/abc/def","../..")+'\n')
print(simplify("/abc/def","../../..")+'\n')
print(simplify("/abc/def",".")+'\n')
print(simplify("/abc/def","..klm")+'\n')
print(simplify("/abc/def","///// ")+'\n')
print(simplify("/abc/def","/a/b/.....")+'\n')
print(simplify("/abc/def","/%/^/a")+'\n')



string1= "/abc/def"
string2= "../gh///../klm/."
print(simplify(string1, string2)+'\n')

